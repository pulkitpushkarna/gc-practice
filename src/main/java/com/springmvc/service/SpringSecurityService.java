package com.springmvc.service;

import com.springmvc.entity.Newer;
import com.springmvc.enums.UserRole;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.security.SocialUser;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SpringSecurityService {

    @Autowired
    NewerRepository newerRepository;

    Newer getCurrentUser() {
        SocialUser socialUser = loggedInUser();
        return newerRepository.findByEmail(socialUser.getUsername());
    }

    Boolean isAdmin() {
        SocialUser user = loggedInUser();
        if (user != null) {
            String authority = user.getAuthorities().stream().findFirst().
                    map(GrantedAuthority::getAuthority)
                    .orElse("");
            return (!StringUtils.isEmpty(authority) && UserRole.valueOf(authority) == UserRole.ROLE_ADMIN);

        }
        return false;
    }

    SocialUser loggedInUser() {
        return (SocialUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
