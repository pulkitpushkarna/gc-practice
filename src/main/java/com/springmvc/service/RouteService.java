package com.springmvc.service;

import com.springmvc.co.RouteCommand;
import com.springmvc.entity.Cab;
import com.springmvc.entity.Route;
import com.springmvc.entity.Stop;
import com.springmvc.repositories.CabRepository;
import com.springmvc.repositories.RouteRepository;
import com.springmvc.repositories.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void insertRoute(RouteCommand routeCommand){
        if(routeCommand != null){
            Set<Long> stopList = routeCommand.getStopIds();
            Route route = new Route();
            Set<Stop> stops = new HashSet<>();
            for (Long stopId:stopList) {
                Stop stop = stopRepository.findOne(stopId);
                if(stop != null){
                   stops.add(stop);
                }
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
             Set<Cab> cabs = route.getCabs();
             cabs.add(cab);
             route.setCabs(cabs);
             routeRepository.save(route);
           }
        }
    }

}
