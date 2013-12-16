package com.paypal.location.config;

/**
 * User: pderoxas
 * Date: 8/21/13
 * Time: 9:21 PM
 * Configuration for all the bean classes needed by the application
 */

import com.paypal.location.config.app.ApplicationConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {
    protected Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ApplicationConfig applicationConfig;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(applicationConfig.getOpsConsoleDataSource().getDriverClass());
        dataSource.setUrl(applicationConfig.getOpsConsoleDataSource().getUrl());
        dataSource.setUsername(applicationConfig.getOpsConsoleDataSource().getUsername());
        dataSource.setPassword(applicationConfig.getOpsConsoleDataSource().getPassword());
        dataSource.setInitialSize(applicationConfig.getOpsConsoleDataSource().getMinConnectionsPerPartition());
        dataSource.setMaxActive(applicationConfig.getOpsConsoleDataSource().getMaxConnectionsPerPartition());
        dataSource.setMaxWait(1000);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(this.dataSource());
        sessionFactoryBean.setPackagesToScan("com.paypal.location");

        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("use_sql_comments", "true");
        properties.put("current_session_context_class", "thread");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
