package com.springmvc.service;

import com.springmvc.auditing.DateTimeService;
import com.springmvc.entity.Cab;
import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.Route;
import com.springmvc.repositories.CabRepository;
import com.springmvc.repositories.CabRouteMappingRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jalajtagra on 06/10/17.
 */
@Service
public class CabRouteMappingService {

    @Autowired
    CabRouteMappingRepository cabRouteMappingRepository;

    @Autowired
    CabRepository cabRepository;

    public void insertCabRouteMapping(Cab cab, Route route){

        CabRouteMapping cabRouteMapping = new CabRouteMapping();
        cabRouteMapping.setCab(cab);
        cabRouteMapping.setRoute(route);
        cabRouteMapping.setMonth(Month.of(Calendar.MONTH));

        cabRouteMappingRepository.save(cabRouteMapping);

    }

    public List<CabRouteMapping> retrieveCabRouteMappingsForMonth(int month, Pageable pageable){

        return cabRouteMappingRepository.findAllByMonth(Month.of(month), pageable);

    }

    public List<Cab> getCabsWithNoRoute(){
        List<CabRouteMapping> mappings = cabRouteMappingRepository.findAllMappingsByMonth(Month.of(Calendar.MONTH));

        List<Cab> cabsWithMapping = mappings.stream().map(ob->{
            return ob.getCab();
        }).collect(Collectors.toList());

        List<Cab> cabs = (List<Cab>) cabRepository.findAll();

        return cabs.stream().filter(obj->
            !cabsWithMapping.contains(obj)
        ).collect(Collectors.toList());
    }

}
