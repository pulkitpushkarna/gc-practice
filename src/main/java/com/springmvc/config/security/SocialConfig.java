package com.springmvc.config.security;

import com.springmvc.config.AppConfig;
import com.springmvc.repositories.NewerRepository;
import com.springmvc.service.AccountConnectSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.sql.DataSource;

/**
 * Created by diwakar on 17/09/17.
 */
@EnableSocial
@Configuration
public class SocialConfig implements SocialConfigurer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private NewerRepository newerRepository;

    /**
     * Callback method to allow configuration of {@link org.springframework.social.connect.ConnectionFactory}s.
     *
     * @param connectionFactoryConfigurer A configurer for adding {@link org.springframework.social.connect.ConnectionFactory} instances.
     * @param environment                 The Spring environment, useful for fetching application credentials needed to create a {@link org.springframework.social.connect.ConnectionFactory} instance.
     */
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        System.out.println("adding connection factory");
        connectionFactoryConfigurer.addConnectionFactory(new GoogleConnectionFactory("359140698416-gv9e78dkjjrq0al0fkm31lp8hvdsnhqj.apps.googleusercontent.com","tGP8iMqHLbMSxsY2On_jEZZM"));
    }

    /**
     * Callback method to enable creation of a {@link UserIdSource} that uniquely identifies the current user.
     *
     * @return the {@link UserIdSource}.
     */
    @Override
    public UserIdSource getUserIdSource() {
        System.out.println("Configure get user id source");
        return new AuthenticationNameUserIdSource();
    }

    /**
     * Callback method to create an instance of {@link UsersConnectionRepository}.
     * Will be used to create a request-scoped instance of {@link org.springframework.social.connect.ConnectionRepository} for the current user.
     *
     * @param connectionFactoryLocator A {@link ConnectionFactoryLocator} to be used by the {@link UsersConnectionRepository}.
     * @return An instance of {@link UsersConnectionRepository}.
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        jdbcUsersConnectionRepository.setConnectionSignUp(new AccountConnectSignupService(newerRepository,appConfig));
        return jdbcUsersConnectionRepository;
    }
}
