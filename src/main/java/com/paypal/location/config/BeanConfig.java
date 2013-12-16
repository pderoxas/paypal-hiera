package com.paypal.location.config;

/**
 * User: pderoxas
 * Date: 8/21/13
 * Time: 9:21 PM
 * Configuration for all the bean classes needed by the application
 */

import com.paypal.common.exceptions.ConfigException;
import com.paypal.common.exceptions.DalException;
import com.paypal.location.config.app.ApplicationConfig;
import com.paypal.location.dal.*;
import com.paypal.location.exceptions.ApplicationConfigException;
import com.paypal.location.exceptions.SSHException;
import com.paypal.location.models.*;
import com.paypal.location.services.*;
import com.paypal.common.utils.JaxbUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import com.paypal.location.models.*;

@Configuration
@ComponentScan(basePackages = {"com.paypal.location.dal","com.paypal.location.models","com.paypal.location.services"})
@EnableTransactionManagement
@EnableScheduling
//@Import({PersistenceConfig.class})
public class BeanConfig {
    protected Logger logger = Logger.getLogger(this.getClass());

    /**
     * These properties can be used to inject values at runtime.
     * Differs from application.xml in that these properties can be injected into annotations
     * via Spring's property injection mechanism.
     * @return PropertyPlaceholderConfigurer
     */
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("runtime.properties"));
        return propertyPlaceholderConfigurer;
    }

    /**
     * The custom application configuration properties defined in application.xml
     * @return ApplicationConfig
     */
    @Bean
    public ApplicationConfig applicationConfig() throws ConfigException, IOException {
        ClassPathResource resource = new ClassPathResource("/runtime.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        String applicationPropertiesFile = props.getProperty("application.properties.file");
        logger.info("********************************************************************");
        logger.info("LOADING application properties file: " + applicationPropertiesFile);
        logger.info("********************************************************************");
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(applicationPropertiesFile);
        return JaxbUtils.unmarsal(inputStream, ApplicationConfig.class);
    }

    /**
     * Instance of the ApplicationConfigHelper class
     * @return ApplicationConfigHelper
     */
    @Bean
    public ApplicationConfigHelper applicationConfigHelper() {
        return new ApplicationConfigHelper();
    }

    //----------------------------------------------
    //DAO BEANS
    //----------------------------------------------

    @Bean
    public ResourceDAO<Location, String> serverDAO() {
        return new LocationDAO();
    }

    //----------------------------------------------
    //SERVICE BEANS
    //----------------------------------------------
    @Bean
    public LocationService serverService() {
        return new LocationService();
    }

}
