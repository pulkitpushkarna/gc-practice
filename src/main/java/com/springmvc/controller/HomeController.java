package com.springmvc.controller;


import com.springmvc.co.CabRequestCO;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Secured("ROLE_NEWER")
public class HomeController {

    @Autowired
    NewerRepository newerRepository;

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @RequestMapping("/cabRequest")
    public String cabRequest(){
        return "cabRequest";
    }

    @RequestMapping("/feedback")
    public String feedback(){
        return "feedback";
    }

    @RequestMapping("/error")
    public String error(){
        return "home";
    }

    @RequestMapping("/cabRequestSubmission")
    @ResponseBody
    public CabRequestCO cabRequestSubmission(CabRequestCO cabRequestCO){
        return cabRequestCO;
    }
}
