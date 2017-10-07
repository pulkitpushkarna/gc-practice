package com.springmvc.service;

import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.MonthlyExpenditure;
import com.springmvc.entity.ZonePrice;
import com.springmvc.repositories.ZonePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jalajtagra on 07/10/17.
 */
@Service
public class CostManagementService {

    @Autowired
    private CabRouteMappingService cabRouteMappingService;

    @Autowired
    private ZonePriceRepository zonePriceRepository;

    public List<MonthlyExpenditure> getMonthlyExpenditures(int year, int month, Pageable pageable){

        Calendar calendar = Calendar.getInstance();
        List<CabRouteMapping> list = cabRouteMappingService.getCabRouteMappingDataForMonth(year, month, pageable);

        if(!CollectionUtils.isEmpty(list)){
            return  list.stream().map(obj->{
                MonthlyExpenditure me = new MonthlyExpenditure();
                me.setCabRouteMapping(obj);
                ZonePrice zonePrice = zonePriceRepository.findByZoneAndCabType(obj.getRoute().getZone(), obj.getCab().getCabType());
                me.setAmountSpend(zonePrice.getCost());
                me.setAmountRecieved(obj.getRoute().getNewerRouteMapping().size()*2200);
                me.setMonth(Month.of(obj.getModificationTime().getMonth()+1));
                //monthlyExpenditureRepository.save(me);
                return me;

            }).collect(Collectors.toList());
        }
        return new ArrayList<MonthlyExpenditure>();
    }



}
