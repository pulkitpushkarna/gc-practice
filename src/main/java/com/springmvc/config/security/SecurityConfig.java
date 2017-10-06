package com.springmvc.config.security;

import com.springmvc.enums.UserRole;
import com.springmvc.service.CustomSocialUserDetailService;
import com.springmvc.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by diwakar on 17/09/17.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final static String ROLE_HIERARCHY_DELIMETER = " > ";

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**","/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserDetailServiceBean());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Configuring Security");
        http
                .formLogin().loginPage("/signin")
                .loginProcessingUrl("/login/authenticate")
                .failureUrl("/login?param.error=bad_credentials").permitAll()
                .and().authorizeRequests()
                .antMatchers("/favicon.ico", "/static-resources/**").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .apply(new SpringSocialConfigurer().postLoginUrl("/").alwaysUsePostLoginUrl(true));
    }

    @Bean
    public UserDetailsService getUserDetailServiceBean(){
        return new CustomUserDetailService();
    }

    @Bean
    public SocialUserDetailsService getSocialUserDetailServiceBean(){
        System.out.println("Getting social service bean");
        return new CustomSocialUserDetailService(userDetailsService());
    }

    @Bean
    public RoleHierarchyImpl roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        // ROLE_GOD > ROLE_ADMIN > ROLE_NEWER
        String roleHierarchyString = Stream.of(
                UserRole.ROLE_GOD.toString(), UserRole.ROLE_ADMIN.toString(), UserRole.ROLE_NEWER.toString()
        ).collect(Collectors.joining(ROLE_HIERARCHY_DELIMETER));

        roleHierarchy.setHierarchy(roleHierarchyString);
        return roleHierarchy;
    }
}
