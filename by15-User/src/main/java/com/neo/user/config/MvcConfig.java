package com.neo.user.config;

import javax.sql.DataSource;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.neo.user.bind.PrimaryDataSource;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author By15
 * @since 2021/9/9 17:10
 */
@Configuration
public class MvcConfig {

    @Autowired
    PrimaryDataSource primaryDataSource;

    @Bean
    @Primary
    public DataSource mainDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(primaryDataSource.getDriverClassName())
                .url(primaryDataSource.getUrl())
                .username(primaryDataSource.getUsername())
                .password(primaryDataSource.getPassword())
                .build();
    }
    @Bean
    @Primary
    public SqlSessionFactory plusSqlSessionFactoryBean(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mapper/*Mapper.xml");
        factoryBean.setMapperLocations(resources);
        factoryBean.setPlugins(new PaginationInterceptor());
        return factoryBean.getObject();
    }

}
