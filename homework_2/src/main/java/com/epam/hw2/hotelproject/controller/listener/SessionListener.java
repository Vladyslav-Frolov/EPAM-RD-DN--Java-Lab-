package com.epam.hw2.hotelproject.controller.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener("SessionListener") // switch to spring-mvc initializer config
public class SessionListener implements HttpSessionListener {
    private static final Logger LOGGER = Logger.getLogger(SessionListener.class);


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOGGER.debug("sessionCreated starts");
        //here session will be invalidated by container within 30 mins
        //if there isn't any activity by user
        se.getSession().setMaxInactiveInterval(30*60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LOGGER.debug("Session destroyed");
    }
}
