package com.springmvc.service;

import com.springmvc.co.RouteCommand;
import com.springmvc.entity.Cab;
import com.springmvc.entity.Newer;
import com.springmvc.entity.Route;
import com.springmvc.entity.Stop;
import com.springmvc.repositories.CabRepository;
import com.springmvc.repositories.RouteRepository;
import com.springmvc.repositories.StopRepository;
import com.springmvc.vo.RouteListVO;
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

    public List<RouteListVO> listRoutes(Pageable pageable) {
        List<Route> routes = routeRepository.findAll(pageable).getContent();
        List<RouteListVO> routeListVOList = new ArrayList<>();
        for (Route route : routes) {
            RouteListVO routeListVO = new RouteListVO();
            List<Stop> stops = route.getStops();
            System.out.println(stops.size());
            routeListVO.setName(route.getRouteName());
            System.out.println(route);
            Stop startPoint = stops.get(0);
            Stop endPoint = stops.get(stops.size() - 1);
            routeListVO.setStartPoint(startPoint.getStopName());
            routeListVO.setEndPoint(endPoint.getStopName());
            routeListVOList.add(routeListVO);
        }
        return routeListVOList;
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
            routeRepository.save(route);
        }
    }

    public List<Newer> getNewersOnRoute(Long id){
        Route route = routeRepository.findOne(id);
        return route.getCabbies();
    }

/*    public void assignCabToRoute(long cabId, long routeId) {
        if (cabId > 0 && routeId > 0) {
            Cab cab = cabRepository.findOne(cabId);
            if (cab != null) {
                Route route = routeRepository.findOne(routeId);
                Cab cabs = route.getCab();
                route.setCab(cab);
                routeRepository.save(route);
            }
        }
    }*/

}
