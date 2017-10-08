package com.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * @author Jitendra Singh.
 */
@ControllerAdvice
public class ExceptionHandlerController {

    private static Logger logger = Logger.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(Exception e) {
        logger.error(e.getMessage());
        return "error404";
    }

    @ExceptionHandler(Exception.class)
    public String handle500(Exception e) {
        logger.error(e.getMessage());
        return "error500";
    }

}
