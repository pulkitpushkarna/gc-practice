package com.springmvc.controller;

import com.springmvc.co.RouteCommand;
import com.springmvc.entity.Cab;
import com.springmvc.entity.Route;
import com.springmvc.entity.Zone;
import com.springmvc.exceptions.BindingException;
import com.springmvc.service.CabService;
import com.springmvc.service.RouteService;
import com.springmvc.service.ZoneService;
import com.springmvc.vo.RouteVO;
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
    private ZoneService zoneService;

    @RequestMapping(path = "/route", method = RequestMethod.GET)
    public String listRoutes(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit, Model model) {
        System.out.println("offset " + offset + "limit");
        List<RouteVO> routeList = routeService.listRoutes(new PageRequest((offset == null) ? 0 : offset, (limit == null) ? 10 : limit));
        model.addAttribute("routes", routeList);
        return "route";
    }

    @RequestMapping(value = "/route/add", method = RequestMethod.GET)
    public String addRoute(Model model) {
        List<Cab> cabList = cabService.getCabsWithNoRoute();
        List<Zone> zoneList = zoneService.getAllZones();
        model.addAttribute("cabs", cabList);
        model.addAttribute("zones", zoneList);
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

    @RequestMapping(value = "/route/update", method = RequestMethod.GET)
    public String updateRoute(@RequestParam long id, Model model) {
        RouteCommand routeCommand = routeService.getRoute(id);
        Cab cab = cabService.getCabByRegId(routeCommand.getCabRegId());
        List<Cab> cabList = cabService.getCabsWithNoRoute();
        List<Zone> zoneList = zoneService.getAllZones();
        cabList.add(cab);
        model.addAttribute("cabs", cabList);
        model.addAttribute("zones", zoneList);
        model.addAttribute("route", routeService.getRoute(id));
        return "addRoute";
    }

    @RequestMapping(value = "/route/remove", method = RequestMethod.DELETE)
    public void deleteRoute(@RequestParam long id) {
        routeService.deleteRoute(id);
    }

}
