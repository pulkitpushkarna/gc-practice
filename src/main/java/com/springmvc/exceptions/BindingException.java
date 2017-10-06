package com.springmvc.exceptions;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by diwakar on 04/10/17.
 */
public class BindingException extends Exception {

    public BindingException(List<ObjectError> errorList){
        for (ObjectError objectError:errorList) {
            System.out.println(objectError.toString());
        }
    }

}
