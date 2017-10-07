package com.springmvc.service;

import com.springmvc.entity.CabRouteMapping;
import com.springmvc.repositories.CabRouteMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by jalajtagra on 07/10/17.
 */
@Service
public class CabRouteMappingService {

    @Autowired
    CabRouteMappingRepository cabRouteMappingRepository;

    public List<CabRouteMapping> getCabRouteMappingDataForMonth(int year, int month, Pageable pageable){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 01);
        Date startDate =  cal.getTime();

        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(year, month, lastDay);
        Date endDate = cal.getTime();
        System.out.println("Dates" + startDate+ "   " + endDate);
        List<CabRouteMapping> list = cabRouteMappingRepository.findAllByCreationTimeBetween(startDate, endDate, pageable);

        return list;

    }


}
