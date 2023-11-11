package com.team11.be.global.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public DataSource memoryDataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb;MODE=MySQL;")
                .username("sa")
                .password("")
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    @Profile("prod")
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3307/hackathon?useSSL=false&allowPublicKeyRetrieval=true")
                .username("root")
                .password("mypassword")
                .type(HikariDataSource.class)
                .build();
    }
}
