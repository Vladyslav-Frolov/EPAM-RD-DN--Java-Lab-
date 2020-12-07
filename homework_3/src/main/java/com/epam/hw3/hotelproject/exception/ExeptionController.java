package com.epam.hw3.hotelproject.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExeptionController {
    private static final Logger LOGGER = Logger.getLogger(ExeptionController.class);

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(HttpServletRequest request, RuntimeException ex){
        LOGGER.error("handleException starts" + request.getRequestURL() + " Threw the Exception ", ex);
        return "error/error_page_RuntimeException";

    }

}
