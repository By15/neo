package com.neo.user.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neo.user.bind.PrimaryDataSource;

/**
 * @author By15
 * @since 2021/9/9 17:10
 */
@Configuration
public class MvcConfig {

    @Autowired
    PrimaryDataSource primaryDataSource;

    @Bean
    public DataSource mainDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("")
                .url(primaryDataSource.getUrl())
                .username(primaryDataSource.getUsername())
                .password(primaryDataSource.getPassword())
                .build();
    }
}
