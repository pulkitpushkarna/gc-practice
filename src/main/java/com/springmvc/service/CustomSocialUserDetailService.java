package com.springmvc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by diwakar on 18/09/17.
 */
public class CustomSocialUserDetailService implements SocialUserDetailsService {

    private UserDetailsService userDetailsService;

    public CustomSocialUserDetailService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * @param userId the user ID used to lookup the user details
     * @return the SocialUserDetails requested
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(String)
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        System.out.println("Looking for user with id "+userId);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
        if(userDetails == null){
            throw new UsernameNotFoundException("No user found with name "+userId);
        }
        return new SocialUser(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }
}
