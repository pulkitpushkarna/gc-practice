package com.springmvc.service;

import com.springmvc.config.AppConfig;
import com.springmvc.entity.Newer;
import com.springmvc.enums.UserRole;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

public class AccountConnectSignupService implements ConnectionSignUp {

    private AppConfig appConfig;

    private RestTemplate restTemplate;

    private NewerRepository newerRepository;
    private static final String TO_THE_NEW = "tothenew.com";

    public AccountConnectSignupService(NewerRepository newerRepository, AppConfig appConfig) {
        this.newerRepository = newerRepository;
        this.appConfig = appConfig;
    }

    /**
     * Sign up a new user of the application from the connection.
     *
     * @param connection the connection
     * @return the new user id. May be null to indicate that an implicit local user profile could not be created.
     */
    @Override
    public String execute(Connection<?> connection) {
        UserProfile userProfile = connection.fetchUserProfile();
        String userEmail = userProfile.getEmail();
        String userId = null;
        if (userEmail != null && userEmail.contains(TO_THE_NEW)) {
            Map<String, Object> newerInfo = getNewerInfo(userEmail);
            Long newerId = Long.parseLong((String) newerInfo.get("employeeCode"));
            Map<String,String> manager = (Map<String, String>) newerInfo.get("reportingManager");
            long managerEmpCode = Long.parseLong(manager.get("employeeCode"));
            userId = UUID.randomUUID().toString();
            Newer newer = new Newer();
            newer.setNewerId(newerId);
            newer.setUsername(userId);
            newer.setPassword(UUID.randomUUID().toString());
            newer.setEmail(userEmail);
            newer.setManagerEmpId(managerEmpCode);
            newer.setFirstName(userProfile.getFirstName());
            newer.setLastName(userProfile.getLastName());
            newer.setUserRole(UserRole.ROLE_NEWER);
            newerRepository.save(newer);
        }
        return userId;
    }

    private Map<String, Object> getNewerInfo(String newerEmail) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> newerInfo = (Map<String, Object>) restTemplate.getForObject(appConfig.getNwUrl() + "/coreApi/employeeByEmail?uuid=" + appConfig.getNwUuid() + "&email=" + newerEmail, Map.class);
        return (Map<String, Object>) newerInfo.get("data");
    }
}
