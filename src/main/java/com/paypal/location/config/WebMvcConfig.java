package com.paypal.location.config;

/**
 * User: pderoxas
 * Date: 8/21/13
 * Time: 9:21 PM
 * Configuration for the mvc-related classes needed by the application
 */

import com.paypal.location.interceptors.ControllerInterceptor;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.ArrayList;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.paypal.location"})
@Import({BeanConfig.class, CacheConfig.class})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ControllerInterceptor());
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
    public ContentNegotiatingViewResolver getContentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        ArrayList<View> defaultViews = new ArrayList<View>();
        MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
        jsonView.setPrefixJson(true);
        defaultViews.add(new MappingJacksonJsonView());
        resolver.setDefaultViews(defaultViews);
        resolver.setOrder(1);
        return resolver;
    }


    @Bean
    public ControllerInterceptor getLoggingInterceptor() {
        return new ControllerInterceptor();
    }
}
