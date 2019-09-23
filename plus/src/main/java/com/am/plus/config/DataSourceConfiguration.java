package com.am.plus.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
@Component
@Configuration
public class DataSourceConfiguration {
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource c=new ComboPooledDataSource();
        c.setDriverClass(driver);
        c.setUser(username);
        c.setJdbcUrl(url);
        c.setPassword(password);
//        c.setAutoCommitOnClose(false);
        return c;
    }

}
