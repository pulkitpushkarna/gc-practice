package com.springmvc.controller;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.repositories.NewerRepository;
import com.springmvc.service.CabRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.security.SocialUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Secured("ROLE_NEWER")
public class HomeController {

    @Autowired
    NewerRepository newerRepository;

//    @RequestMapping(value = "/")
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView("home");
//        return modelAndView;
//    }

    @RequestMapping("/feedback")
    public String feedback(){
        return "feedback";
    }

    @RequestMapping("/error")
    public String error(){
        return "home";
    }



}
