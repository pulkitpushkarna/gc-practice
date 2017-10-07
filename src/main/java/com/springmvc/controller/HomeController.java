package com.springmvc.controller;

import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    NewerRepository newerRepository;

    @RequestMapping(value = "/")
    public ModelAndView home(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping("/feedback")
    public String feedback(){
        return "feedback";
    }

    @RequestMapping("/error")
    public String error(){
        return "home";
    }



}
