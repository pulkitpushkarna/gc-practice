package com.springmvc.service;

import com.springmvc.co.RouteCommand;
import com.springmvc.entity.Cab;
import com.springmvc.entity.Route;
import com.springmvc.entity.Stop;
import com.springmvc.repositories.CabRepository;
import com.springmvc.repositories.RouteRepository;
import com.springmvc.repositories.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by diwakar on 02/10/17.
 */
@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private CabRepository cabRepository;

    public List<Route> listRoutes(Pageable pageable){
        Page<Route> routes = routeRepository.findAll(pageable);
        return routes.getContent();
    }

    public void insertRoute(RouteCommand routeCommand){
        if(routeCommand != null){
            Set<String> stopList = routeCommand.getStops();
            Route route = new Route();
            List<Stop> stops = new ArrayList<>();
            for (String stopName:stopList) {
                Stop stop = new Stop();
                stop.setStopName(stopName);
            }
            route.setRouteName(routeCommand.getRouteName());
            route.setStops(stops);
            routeRepository.save(route);
        }
    }

    public void assignCabToRoute(long cabId, long routeId){
        if(cabId > 0 && routeId > 0){
           Cab cab = cabRepository.findOne(cabId);
           if(cab != null){
             Route route = routeRepository.findOne(routeId);
             Cab cabs = route.getCab();
             route.setCab(cab);
             routeRepository.save(route);
           }
        }
    }

}
