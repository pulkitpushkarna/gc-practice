package com.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author Jitendra Singh.
 */
@ControllerAdvice
public class ExceptionHandlerController {

    private static Logger logger = Logger.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler
    public String handle(Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        return "error";
    }
}
