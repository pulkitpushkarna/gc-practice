package com.springmvc.config;


import com.springmvc.config.security.SecurityConfig;
import com.springmvc.config.security.SocialConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                RootConfig.class, WebConfig.class, PersistenceConfig.class, SecurityConfig.class, SocialConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        boolean done = registration.setInitParameter("throwExceptionIfNoHandlerFound", "true"); // -> true
        if(!done) throw new RuntimeException();
    }
}
