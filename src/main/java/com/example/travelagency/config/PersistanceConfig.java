package com.example.travelagency.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistanceConfig {

    @Value("${persistance.driverClassName}")
    private String driverClassName;
    @Value("${persistance.url}")
    private String url;
    @Value("${persistance.username}")
    private String username;
    @Value("${persistance.password}")
    private String password;

    @Bean
    public DataSource postgresConnection() {
        return DataSourceBuilder.create().
                driverClassName(driverClassName).
                url(url).
                username(username).
                password(password).
                build();

    }
}
