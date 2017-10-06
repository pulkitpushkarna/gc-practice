package com.springmvc.controller;

import com.springmvc.co.RouteCommand;
import com.springmvc.entity.Cab;
import com.springmvc.entity.Route;
import com.springmvc.exceptions.BindingException;
import com.springmvc.service.CabRouteMappingService;
import com.springmvc.service.CabService;
import com.springmvc.service.RouteService;
import com.springmvc.vo.RouteListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private CabRouteMappingService cabRouteMappingService;

    @RequestMapping(path = "/route", method = RequestMethod.GET)
    public String listRoutes(@RequestParam int offset, @RequestParam int limit, Model model) {
        System.out.println("offset " +offset + "limit");
        List<RouteListVO> routeList = routeService.listRoutes(new PageRequest(offset,limit));
        model.addAttribute("routes", routeList);
        return "route";
    }

    @RequestMapping(value = "/route/add", method = RequestMethod.GET)
    public String addRoute(Model model) {
        List<Cab> cabList = cabRouteMappingService.getCabsWithNoRoute();
        model.addAttribute("cabs", cabList);
        return "addRoute";
    }

    @RequestMapping(value = "/route/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean insertRoute(@RequestBody RouteCommand routeCommand, BindingResult bindingResult) throws Exception {
        System.out.println(routeCommand);
        if (bindingResult.hasErrors()) {
            throw new BindingException(bindingResult.getAllErrors());
        } else {
            routeService.insertRoute(routeCommand);
            return true;
        }
    }

}
