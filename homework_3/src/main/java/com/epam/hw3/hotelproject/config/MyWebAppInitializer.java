package com.epam.hw3.hotelproject.config;

import com.epam.hw3.hotelproject.config.filter.AccessFilter;
import com.epam.hw3.hotelproject.config.filter.SessionLocaleFilter;
import com.epam.hw3.hotelproject.config.filter.SessionParametersFilter;
import com.epam.hw3.hotelproject.config.listener.ContextListener;
import com.epam.hw3.hotelproject.config.listener.SessionListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // The first thing we will need to do is create the application context for the servlet.
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();

        // This type of context can then be configured registering a configuration class:
         context.register(SpringConfig.class);

        // we can add a listener to the ServletContext that will load the context:
        container.addListener(new ContextLoaderListener(context));
        // Or setting an entire package that will be scanned for configuration classes:
//        context.setConfigLocation("com.epam.hw3.hotelproject");

        // registered other custom listeners
        container.addListener(SessionListener.class); // session
        container.addListener(ContextListener.class); // log4j

        // The next step is creating and registering our dispatcher servlet:
        ServletRegistration.Dynamic dispatcher = container
                .addServlet("dispatcher", new DispatcherServlet(context));

        // init parameter
        container.setInitParameter("language", "uk");
        container.setInitParameter("log4j-config-location", "WEB-INF/log4j.properties");

        // filters, AccessFilter match after
        container.addFilter("SessionParametersFilter", SessionParametersFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
        container.addFilter("SessionLocaleFilter", SessionLocaleFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
        container.addFilter("AccessFilter", AccessFilter.class)
                .addMappingForUrlPatterns(null, true, "/*");

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
