//package com.am.plus.config;
//
//import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//import java.beans.PropertyVetoException;
//
//@Configuration
//public class MybatisPlusConfiguration {
//    @Autowired
//    private DataSourceConfiguration configuration;
//    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean() throws PropertyVetoException {
//        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean=new MybatisSqlSessionFactoryBean();
//        mybatisSqlSessionFactoryBean.setDataSource(configuration.createDataSource());
//        return mybatisSqlSessionFactoryBean;
//    }
//}
