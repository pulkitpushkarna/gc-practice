package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CostManagementController {



    @RequestMapping("/costManagement")
    ModelAndView costManagement(){

        ModelAndView modelAndView = new ModelAndView("costManagement");
        return modelAndView;
    }
}
