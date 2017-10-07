package com.springmvc.service;

import com.springmvc.co.CabCommand;
import com.springmvc.entity.Cab;
import com.springmvc.entity.CabRouteMapping;
import com.springmvc.enums.CabType;
import com.springmvc.repositories.CabRepository;
import com.springmvc.repositories.CabRouteMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by diwakar on 05/10/17.
 */
@Service
public class CabService {

    @Autowired
    private CabRepository cabRepository;

    @Autowired
    private CabRouteMappingRepository cabRouteMappingRepository;

    public List<Cab> getCabsWithNoRoute(){
        return cabRepository.findByCabRouteMappingListIsNull();
    }

    public List<Cab> getAllCabs(){
        return (List<Cab>) cabRepository.findAll();
    }

    public List<Cab> listCabs(Pageable pageable){
        Page<Cab> cabPage = cabRepository.findAll(pageable);
        return cabPage.getContent();
    }

    public void insertCab(CabCommand cabCommand){
        Cab cab = new Cab();
        cab.setVehicleRegNumber(cabCommand.getVehicleRegNo());
        cab.setCabType(cabCommand.getCabType());
        cab.setVehicleModel(cabCommand.getCabModel());

        cabRepository.save(cab);
    }

}
