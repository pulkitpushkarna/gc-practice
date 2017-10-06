package com.springmvc.controller;

import com.springmvc.co.RouteCommand;
import com.springmvc.entity.Cab;
import com.springmvc.entity.Route;
import com.springmvc.exceptions.BindingException;
import com.springmvc.service.CabService;
import com.springmvc.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by diwakar on 04/10/17.
 */
@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private CabService cabService;

    @RequestMapping(path = "/route", method = RequestMethod.GET)
    public String listRoutes(Model model) {
//        model.addAttribute("routes", routeService.listRoutes(pageable));
        return "route";
    }

    @RequestMapping(value = "/route/add", method = RequestMethod.GET)
    public String addRoute(Model model){
        List<Cab> cabList = cabService.getCabsWithNoRoute();
        model.addAttribute("cabs",cabList);
        return "addRoute";
    }

    @RequestMapping(value = "/route/add" , method = RequestMethod.POST)
    @ResponseBody
    public boolean insertRoute(@RequestBody RouteCommand routeCommand, BindingResult bindingResult) throws Exception{
        System.out.println(routeCommand);
        if(bindingResult.hasErrors()){
            throw new BindingException(bindingResult.getAllErrors());
        } else {
           routeService.insertRoute(routeCommand);
           return true;
        }
    }

}
