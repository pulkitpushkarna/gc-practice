package com.springmvc.controller;


import com.springmvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @RequestMapping("/signin")
    public String signIn(){
        return "signin";
    }

    @RequestMapping("/error")
    public String error(){
        return "home";
    }
}
