package com.springmvc.service;

import com.springmvc.co.CabCommand;
import com.springmvc.entity.Cab;
import com.springmvc.repositories.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by diwakar on 05/10/17.
 */
@Service
public class CabService {

    @Autowired
    private CabRepository cabRepository;

    public List<Cab> getCabsWithNoRoute(){
        return null;
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
        cab.setCabType(cabCommand.getCapacity());
        cab.setVehicleModel(cabCommand.getCabModel());

        cabRepository.save(cab);
    }

}
