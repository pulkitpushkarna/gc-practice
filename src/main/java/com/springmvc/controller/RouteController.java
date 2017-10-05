package com.springmvc.controller;

import com.springmvc.co.RouteCommand;
import com.springmvc.entity.Route;
import com.springmvc.exceptions.BindingExceptions;
import com.springmvc.repositories.RouteRepository;
import com.springmvc.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by diwakar on 04/10/17.
 */
@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;

    @RequestMapping(path = "/route", method = RequestMethod.GET)
    public String listRoutes(Model model) {
//        model.addAttribute("routes", routeService.listRoutes(pageable));
        return "route";
    }

    @RequestMapping(value = "/route/add", method = RequestMethod.GET)
    public String addRoute(){
        return "addRoute";
    }

    @RequestMapping(value = "/route/add" , method = RequestMethod.POST)
    @ResponseBody
    public boolean insertRoute(@RequestBody RouteCommand routeCommand, BindingResult bindingResult) throws Exception{
        System.out.println(routeCommand);
        if(bindingResult.hasErrors()){
            throw new BindingExceptions(bindingResult.getAllErrors());
        } else {
           routeService.insertRoute(routeCommand);
           return true;
        }
    }

}
