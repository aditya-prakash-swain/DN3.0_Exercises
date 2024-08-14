package com.example.EmployeeManagementSystem.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class HibernateConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("primaryDataSource") DataSource dataSource) { // Specify the correct DataSource
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.EmployeeManagementSystem"); // Update with your entity package
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); // Use your database dialect
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.jdbc.batch_size", "10");
        em.setJpaProperties(props);
        
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            @Qualifier("primaryDataSource") DataSource dataSource) { // Use the same DataSource
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource).getObject());
        return transactionManager;
    }
}
