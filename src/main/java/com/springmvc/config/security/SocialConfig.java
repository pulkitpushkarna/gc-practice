package com.springmvc.config.security;

import com.springmvc.config.AppConfig;
import com.springmvc.repositories.NewerRepository;
import com.springmvc.service.AccountConnectSignupService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfiguration;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.connect.GoogleAdapter;
import org.springframework.social.google.connect.GoogleServiceProvider;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SocialAuthenticationServiceRegistry;
import org.springframework.social.security.provider.OAuth1AuthenticationService;
import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

/**
 * Created by diwakar on 17/09/17.
 */
@Configuration
public class SocialConfig extends SocialConfiguration implements SocialConfigurer, InitializingBean {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private Environment environment;

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
        connectionFactoryConfigurer.addConnectionFactory(new CustomizedGoogleConnectionFactory("359140698416-gv9e78dkjjrq0al0fkm31lp8hvdsnhqj.apps.googleusercontent.com", "tGP8iMqHLbMSxsY2On_jEZZM"));
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
        jdbcUsersConnectionRepository.setConnectionSignUp(new AccountConnectSignupService(newerRepository, appConfig));
        return jdbcUsersConnectionRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setSocialConfigurers(Collections.emptyList());
    }

    public void setSocialConfigurers(List<SocialConfigurer> socialConfigurers) {
        List<SocialConfigurer> configurers = Collections.singletonList(this);
        super.setSocialConfigurers(configurers);
    }

    static class CustomizedGoogleConnectionFactory extends OAuth2ConnectionFactory<Google> {

        public CustomizedGoogleConnectionFactory(String clientId, String clientSecret) {
            super("google", new GoogleServiceProvider(clientId, clientSecret),
                    new GoogleAdapter());
        }

        @Override
        protected String extractProviderUserId(AccessGrant accessGrant) {
            Google api = ((GoogleServiceProvider) getServiceProvider()).getApi(accessGrant.getAccessToken());
            UserProfile userProfile = getApiAdapter().fetchUserProfile(api);
            return userProfile.getUsername();
        }
    }

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        CustomSecurityEnabledConnectionFactoryConfigurer cfConfig = new CustomSecurityEnabledConnectionFactoryConfigurer();
        addConnectionFactories(cfConfig, environment);
        return cfConfig.getConnectionFactoryLocator();
    }


    static class CustomSecurityEnabledConnectionFactoryConfigurer implements ConnectionFactoryConfigurer {

        private SocialAuthenticationServiceRegistry registry;

        public CustomSecurityEnabledConnectionFactoryConfigurer() {
            registry = new SocialAuthenticationServiceRegistry();
        }

        public void addConnectionFactory(ConnectionFactory<?> connectionFactory) {
            registry.addAuthenticationService(wrapAsSocialAuthenticationService(connectionFactory));
        }

        public ConnectionFactoryRegistry getConnectionFactoryLocator() {
            return registry;
        }


        private <A> SocialAuthenticationService<A> wrapAsSocialAuthenticationService(ConnectionFactory<A> cf) {
            if (cf instanceof OAuth1ConnectionFactory) {
                return new OAuth1AuthenticationService<A>((OAuth1ConnectionFactory<A>) cf);
            } else if (cf instanceof OAuth2ConnectionFactory) {
                final OAuth2AuthenticationService<A> authService = new GoogleOAuth2AuthenticatioService<A>((OAuth2ConnectionFactory<A>) cf);
                authService.setDefaultScope(((OAuth2ConnectionFactory<A>) cf).getScope());
                return authService;
            }
            throw new IllegalArgumentException("The connection factory must be one of OAuth1ConnectionFactory or OAuth2ConnectionFactory");
        }
    }

//    @Component
    public static class GoogleOAuth2AuthenticatioService<A> extends OAuth2AuthenticationService<A> {

//        @Value("${app.springsocial.redirect_uri}")
        private String redirectUri = "http://35.164.55.166/auth/google";

        public GoogleOAuth2AuthenticatioService(OAuth2ConnectionFactory<A> connectionFactory) {
            super(connectionFactory);
        }

        @Override
        protected String buildReturnToUrl(HttpServletRequest request) {
//            if(!StringUtils.isEmpty(redirectUri)) {
//                return redirectUri;
//            }
String url = super.buildReturnToUrl(request);
            System.out.println("GENERATED REDIRECT URI ----------------------- "+url);
            return url;
        }
    }
}
