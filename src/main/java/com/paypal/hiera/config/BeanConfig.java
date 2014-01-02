package com.paypal.hiera.config;

/**
 * User: pderoxas
 * Date: 8/21/13
 * Time: 9:21 PM
 * Configuration for all the bean classes needed by the application
 */

import com.paypal.common.exceptions.ConfigException;
import com.paypal.hiera.dal.*;
import com.paypal.hiera.models.*;
import com.paypal.hiera.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;

//import com.paypal.hiera.models.*;

@Configuration
@ComponentScan(basePackages = {"com.paypal.hiera.dal","com.paypal.hiera.models","com.paypal.hiera.services"})
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
     * The custom runtime properties
     * @return Properties
     */
    @Bean
    public Properties runtimeProperties() throws ConfigException, IOException {
        ClassPathResource resource = new ClassPathResource("/runtime.properties");
        return PropertiesLoaderUtils.loadProperties(resource);
    }

    //----------------------------------------------
    //DAO BEANS
    //----------------------------------------------

    @Bean
    public ResourceDAO<LocationConfig, String> geoLocationDAO() {
        return new LocationDAO();
    }

    @Bean
    public ResourceDAO<StoreConfig, String> storeDAO() {
        return new StoreDAO();
    }

    @Bean
    public ResourceDAO<GroupConfig, String> storeGroupDAO() {
        return new GroupDAO();
    }



    //----------------------------------------------
    //SERVICE BEANS
    //----------------------------------------------
    @Bean
    public LocationService geoLocationService() {
        return new LocationService();
    }

    @Bean
    public StoreService storeService() {
        return new StoreService();
    }

    @Bean
    public GroupService storeGroupService() {
        return new GroupService();
    }



}
