package com.neo.user.bind;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @author By15
 * @since 2021/9/9 17:10
 */
@ConfigurationProperties(prefix = "spring.dataSource")
@Configuration
@Data
public class PrimaryDataSource {
    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
