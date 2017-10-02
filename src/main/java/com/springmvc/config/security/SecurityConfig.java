package com.springmvc.config.security;

import com.springmvc.service.CustomSocialUserDetailService;
import com.springmvc.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by diwakar on 17/09/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


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
}
