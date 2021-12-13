package com.neo.user.bind;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author By15
 * @since 2021/9/9 17:10
 */
@ConfigurationProperties(prefix = "server.datasource")
@Component
@Data
public class PrimaryDataSource {
    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
