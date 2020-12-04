package com.epam.hw2.hotelproject.config;

import com.epam.hw2.hotelproject.timed.TimedController;
import com.epam.hw2.hotelproject.timed.TimedHandlerBeanPostProcessor;
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
@ComponentScan("com.epam.hw2.hotelproject")
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

    // test
    @Bean
    public TimedHandlerBeanPostProcessor profilingHandlerBeanPostProcessor() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        return new TimedHandlerBeanPostProcessor();
    }

    @Bean
    public TimedController profilingController(){
        return new TimedController();
    }

}
