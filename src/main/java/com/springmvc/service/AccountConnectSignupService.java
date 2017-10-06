package com.springmvc.service;

import com.springmvc.entity.Newer;
import com.springmvc.entity.Role;
import com.springmvc.enums.UserRole;
import com.springmvc.repositories.NewerRepository;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AccountConnectSignupService implements ConnectionSignUp {

    private NewerRepository newerRepository;
    private static final String TO_THE_NEW = "tothenew.com";

    public AccountConnectSignupService(NewerRepository newerRepository) {
        this.newerRepository = newerRepository;
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
            userId = UUID.randomUUID().toString();
            Newer newer = new Newer();
            newer.setUsername(userId);
            newer.setPassword(UUID.randomUUID().toString());
            newer.setEmail(userEmail);
            newer.setFirstName(userProfile.getFirstName());
            newer.setLastName(userProfile.getLastName());
            newer.setUserRole(UserRole.ROLE_NEWER);
            newerRepository.save(newer);
        }
        return userId;
    }
}
