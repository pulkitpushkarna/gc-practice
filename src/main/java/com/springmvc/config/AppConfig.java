package com.springmvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by diwakar on 07/10/17.
 */
@Configuration
public class AppConfig {

    @Value("${app.datasource.username}")
    private String username;
    @Value("${app.datasource.password}")
    private String password;
    @Value("${app.datasource.driverClass}")
    private String driverClass;
    @Value("${app.datasource.url}")
    private String url;
    @Value("${app.newersworld.url}")
    private String nwUrl;
    @Value("${app.newersworld.uuid}")
    private String nwUuid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNwUrl() {
        return nwUrl;
    }

    public void setNwUrl(String nwUrl) {
        this.nwUrl = nwUrl;
    }

    public String getNwUuid() {
        return nwUuid;
    }

    public void setNwUuid(String nwUuid) {
        this.nwUuid = nwUuid;
    }
}
