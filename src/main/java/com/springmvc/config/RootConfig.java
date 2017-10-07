package com.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Configuration
public class RootConfig {

    @Autowired
    private MailProps mailProps;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailProps.getHost());
        mailSender.setPort(mailProps.getPort());

        mailSender.setUsername(mailProps.getUsername());
        mailSender.setPassword(mailProps.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Component
    public static class MailProps {

        @Value("${app.mail.host}")
        private String host;
        @Value("${app.mail.port}")
        private int port;
        @Value("${app.mail.username}")
        private String username;
        @Value("${app.mail.password}")
        private String password;

        public String getHost() {
            return host;
        }

        public MailProps setHost(String host) {
            this.host = host;
            return this;
        }

        public int getPort() {
            return port;
        }

        public MailProps setPort(int port) {
            this.port = port;
            return this;
        }

        public String getUsername() {
            return username;
        }

        public MailProps setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public MailProps setPassword(String password) {
            this.password = password;
            return this;
        }
    }
}
