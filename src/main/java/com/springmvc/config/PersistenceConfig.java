package com.springmvc.config;

import com.springmvc.auditing.AuditingDateTimeProvider;
import com.springmvc.auditing.CurrentDateTimeService;
import com.springmvc.auditing.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("com.springmvc.repositories")
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")

public class PersistenceConfig {

    @Autowired
    private AppConfig appConfig;

    @Bean
    DateTimeService currentTimeDateTimeService(){
        return new CurrentDateTimeService();
    }

    @Bean
    DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {
        return new AuditingDateTimeProvider(dateTimeService);
    }
    @Bean
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(appConfig.getDriverClass());
        driverManagerDataSource.setUrl(appConfig.getUrl());
        driverManagerDataSource.setUsername(appConfig.getUsername());
        driverManagerDataSource.setPassword(appConfig.getPassword());
        return driverManagerDataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.springmvc.entity");
        Properties jpaProperties= new Properties();
        jpaProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        jpaProperties.setProperty("hibernate.show_sql","true");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto","update");
        jpaProperties.setProperty("hibernate.enable_lazy_load_no_trans","true");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
