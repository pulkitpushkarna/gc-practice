package com.springmvc.service;

import com.springmvc.entity.Newer;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.security.SocialUser;
import org.springframework.stereotype.Service;

@Service
public class SpringSecurityService {

    @Autowired
    NewerRepository newerRepository;

    public Newer getCurrentUser(){
        SocialUser socialUser=(SocialUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return newerRepository.findByEmail(socialUser.getUsername());
    }
}
