package com.epam.hw4.config;

import com.epam.hw4.timed.TimedController;
import com.epam.hw4.timed.TimedHandlerBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

@Configuration
@ComponentScan(basePackages = "com.epam.hw4")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    // ApplicationContext
    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
    }

    // css + favicon
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/css/");
    }

    // ViewResolver
    @Bean
    protected InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // timed
    @Bean
    public TimedHandlerBeanPostProcessor timedHandlerBeanPostProcessor()
            throws MalformedObjectNameException, NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException {
        return new TimedHandlerBeanPostProcessor();
    }

    @Bean
    public TimedController timedController(){
        return new TimedController();
    }

}
