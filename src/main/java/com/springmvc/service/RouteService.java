package com.springmvc.service;

import com.springmvc.co.RouteCommand;
import com.springmvc.entity.*;
import com.springmvc.repositories.*;
import com.springmvc.vo.RouteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private CabRouteMappingRepository cabRouteMappingRepository;

    public List<RouteVO> listRoutes(Pageable pageable) {
        List<Route> routes = routeRepository.findAll(pageable).getContent();
        List<RouteVO> routeVOList = new ArrayList<>();
        for (Route route : routes) {
            RouteVO routeVO = new RouteVO();
            List<CabRouteMapping> cabRouteMappings = route.getCabRouteMapping();
            Optional<CabRouteMapping> cabRouteMapping = cabRouteMappings.stream().filter(CabRouteMapping::getActive).findFirst();
            if (cabRouteMapping.isPresent()) {
                Cab cab = cabRouteMapping.get().getCab();
                routeVO.setCabName(cab.getVehicleModel() + "-" + cab.getVehicleRegNumber());
            }
            routeVO.setRouteId(route.getId());
            routeVO.setZone(route.getZone().getName());
            routeVO.setCreatedOn(route.getCreationTime());
            routeVO.setTotalNewersInRoute((int) (route.getNewerRouteMapping().stream().filter(NewerRouteMapping::isActive).count()));
            List<Stop> stops = route.getStops();
            routeVO.setName(route.getRouteName());
            System.out.println(route);
            Stop startPoint = stops.get(0);
            Stop endPoint = stops.get(stops.size() - 1);
            routeVO.setStartPoint(startPoint.getStopName());
            routeVO.setEndPoint(endPoint.getStopName());
            routeVOList.add(routeVO);
        }
        return routeVOList;
    }

    public void insertRoute(RouteCommand routeCommand) {
        if (routeCommand != null) {
            List<String> stopList = routeCommand.getStops();
            Cab cab = cabRepository.findByVehicleRegNumber(routeCommand.getCabRegId());
            Route route = new Route();
            List<Stop> stops = new ArrayList<>();
            for (String stopName : stopList) {
                Stop stop = new Stop();
                stop.setStopName(stopName);
                stops.add(stop);
            }
            route.setRouteName(routeCommand.getRouteName());
            route.setStops(stops);
            Zone zone = zoneRepository.findByName(routeCommand.getZoneName());
            route.setZone(zone);
            CabRouteMapping cabRouteMapping = new CabRouteMapping();
            List<CabRouteMapping> cabRouteMappings = new ArrayList<>();
            cabRouteMapping.setCab(cab);
            cabRouteMapping.setRoute(route);
            cabRouteMapping.setActive(true);
            cabRouteMappings.add(cabRouteMapping);
            route.setCabRouteMapping(cabRouteMappings);
            routeRepository.save(route);
        }
    }

    public void deleteRoute(long id){
        routeRepository.delete(id);
    }

    public RouteCommand getRoute(long id){
        Route route = routeRepository.findOne(id);
        RouteCommand routeCommand = new RouteCommand();
        Optional<CabRouteMapping> cabRouteMapping = route.getCabRouteMapping().stream().filter(CabRouteMapping::getActive).findFirst();
        cabRouteMapping.ifPresent(cabRouteMapping1 -> routeCommand.setCabRegId(cabRouteMapping1.getCab().getVehicleRegNumber()));
        routeCommand.setRouteName(route.getRouteName());
        routeCommand.setStops(route.getStops().stream().map(Stop::getStopName).collect(Collectors.toList()));
        routeCommand.setZoneName(route.getZone().getName());
        return routeCommand;
    }

}
