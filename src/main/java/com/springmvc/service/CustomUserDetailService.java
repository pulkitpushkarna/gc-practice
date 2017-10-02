package com.springmvc.service;

import com.springmvc.entity.Newer;
import com.springmvc.entity.Role;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by diwakar on 17/09/17.
 */
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private NewerRepository newerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername called " + username);
        Newer newer = newerRepository.findByUsername(username);
        if (newer == null) {
            throw new UsernameNotFoundException("No newer found with username " + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> newerRoles = newer.getUserRoles();
        for (Role role : newerRoles) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getUserRole().toString());
            grantedAuthorities.add(simpleGrantedAuthority);
        }
        return new User(newer.getUsername(), newer.getPassword(), grantedAuthorities);
    }
}
