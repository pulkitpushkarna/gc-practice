package com.springmvc.events;

import com.springmvc.entity.*;
import com.springmvc.enums.UserRole;
import com.springmvc.repositories.CabRepository;
import com.springmvc.repositories.CabRouteMappingRepository;
import com.springmvc.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private CabRepository cabRepository;

    @Autowired
    private CabRouteMappingRepository cabRouteMappingRepository;

    @EventListener(ContextRefreshedEvent.class)
    void startUpEvent(){
        Cab cab = new Cab();
        cab.setVehicleRegNumber("DL-935");
        cab.setMaxCapacity(8);
        cab.setCost(20000);
        cabRepository.save(cab);
        Stop stop1 = new Stop();
        stop1.setStopName("Stop 1");
        Stop stop2 = new Stop();
        stop2.setStopName("Stop 2");
        List<Stop> stops = new ArrayList<>();
        stops.add(stop1);
        stops.add(stop2);
        Route route = new Route();
        route.setActive(true);
        route.setRouteName("Random Route");
        route.setStops(stops);
        routeRepository.save(route);
        CabRouteMapping cabRouteMapping = new CabRouteMapping();
        cabRouteMapping.setMonth(Month.JANUARY);
        cabRouteMapping.setRoute(route);
        cabRouteMapping.setCab(cab);
        cabRouteMappingRepository.save(cabRouteMapping);
    }

}
