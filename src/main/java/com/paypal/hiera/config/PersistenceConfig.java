package com.paypal.hiera.config;

/**
 * User: pderoxas
 * Date: 8/21/13
 * Time: 9:21 PM
 * Configuration for all the bean classes needed by the application
 */

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {
    protected Logger logger = Logger.getLogger(this.getClass());

    @Bean
    public DataSource dataSource() {

        ClassPathResource resource = new ClassPathResource("/runtime.properties");
        BasicDataSource dataSource = new BasicDataSource();
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            dataSource.setDriverClassName(props.getProperty("dbClassName"));
            dataSource.setUrl(props.getProperty("dbUrl"));
            dataSource.setUsername(props.getProperty("dbUsername"));
            dataSource.setPassword(props.getProperty("dbPassword"));
            dataSource.setInitialSize(5);
            dataSource.setMaxActive(10);
            dataSource.setMaxWait(1000);
        } catch (IOException e) {


            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(this.dataSource());
        sessionFactoryBean.setPackagesToScan("com.paypal.hiera");

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
