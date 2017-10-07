package com.springmvc.events;

import com.springmvc.co.VendorCO;
import com.springmvc.co.ZoneCO;
import com.springmvc.entity.*;
import com.springmvc.enums.BaseZone;
import com.springmvc.enums.CabType;
import com.springmvc.enums.Vendor;
import com.springmvc.repositories.*;
import com.springmvc.repositories.VendorRepository;
import com.springmvc.repositories.ZoneRepository;
import com.springmvc.service.VendorService;
import com.springmvc.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap {

    @Autowired
    ZoneService zoneService;
    @Autowired
    VendorService vendorService;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    ZonePriceRepository zonePriceRepository;
    @Autowired
    CabRouteMappingRepository cabRouteMappingRepository;
    @Autowired
    ZoneRepository zoneRepository;
    @Autowired
    VendorRepository vendorRepository;

    @EventListener(ContextRefreshedEvent.class)
    void startUpEvent() {


//        for (BaseZone zone : BaseZone.values()) {
//            ZoneCO zoneCO = new ZoneCO();
//            zoneCO.setName(zone.getName());
//            zoneService.saveZone(zoneCO);
//
//            ZonePrice zp = new ZonePrice();
//            zp.setCabType(CabType.FOUR_SEARTER);
//            zp.setCost(100);
//            zp.setZone(zoneRepository.findByName(zone.getName()));
//
//            ZonePrice zp2 = new ZonePrice();
//            zp2.setCabType(CabType.SEVEN_SEATER);
//            zp2.setCost(200);
//            zp2.setZone(zoneRepository.findByName(zone.getName()));
//
//            zonePriceRepository.save(zp);
//            zonePriceRepository.save(zp2);
//
//
//        }
//        System.out.println("vendorRepository.findAll()>>>>>"+vendorRepository.findAll());
//        if(ObjectUtils.isEmpty(vendorRepository.findAll())) {
//            for (Vendor vendor : Vendor.values()) {
//                VendorCO vendorCO = new VendorCO();
//                vendorCO.setName(vendor.getName());
//                vendorService.saveVendor(vendorCO);
//            }
//        }
//
//
//        Cab cab = new Cab();
//        cab.setVehicleRegNumber("DL-15RD6651");
//        cab.setCabType(CabType.FOUR_SEARTER);
//        cab.setVehicleModel("Wagon-R");
//
//        cabRepository.save(cab);
//
//        Route route = new Route();
//
//        List<Stop> stopList = new ArrayList<Stop>();
//        Stop stop = new Stop();
//        stop.setStopName("Dwarka");
//        stopList.add(stop);
//        route.setStops(stopList);
//        route.setRouteName("Dwarka Route");
//
//        Zone zone = new Zone();
//        zone.setName("Beast");
//        zoneRepository.save(zone);
//
//        ZonePrice zp = new ZonePrice();
//        zp.setCabType(CabType.FOUR_SEARTER);
//        zp.setCost(100);
//        zp.setZone(zoneRepository.findByName(zone.getName()));
//
//        ZonePrice zp2 = new ZonePrice();
//        zp2.setCabType(CabType.SEVEN_SEATER);
//        zp2.setCost(200);
//        zp2.setZone(zoneRepository.findByName(zone.getName()));
//
//        zonePriceRepository.save(zp);
//        zonePriceRepository.save(zp2);
//
//        route.setZone(zone);
//        routeRepository.save(route);
//
//        CabRouteMapping cabRouteMapping = new CabRouteMapping();
//        cabRouteMapping.setCab(cab);
//        cabRouteMapping.setRoute(route);
//
//        cabRouteMappingRepository.save(cabRouteMapping);

    }
}
