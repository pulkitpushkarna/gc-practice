package com.springmvc.service;

import com.springmvc.entity.Newer;
import com.springmvc.entity.Role;
import com.springmvc.enums.UserRole;
import com.springmvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by diwakar on 18/09/17.
 */
public class AccountConnectSignupService implements ConnectionSignUp {

    private UserRepository userRepository;

    public AccountConnectSignupService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        String userId = UUID.randomUUID().toString();
        System.out.println(userProfile.getEmail());
        Newer newer = new Newer();
        newer.setUsername(userId);
        newer.setPassword("random Password");
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setUserRole(UserRole.ROLE_NEWER);
        roles.add(role);
        newer.setUserRoles(roles);
        userRepository.save(newer);
        return userId;
    }
}
