package com.springmvc.events;

import com.springmvc.co.VendorCO;
import com.springmvc.co.ZoneCO;
import com.springmvc.enums.BaseZone;
import com.springmvc.enums.Vendor;
import com.springmvc.repositories.VendorRepository;
import com.springmvc.repositories.ZoneRepository;
import com.springmvc.service.VendorService;
import com.springmvc.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class Bootstrap {

    @Autowired
    ZoneService zoneService;

    @Autowired
    VendorService vendorService;

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    VendorRepository vendorRepository;

    @EventListener(ContextRefreshedEvent.class)
    void startUpEvent() {
        System.out.println("zoneRepository.findAll()>>>>"+zoneRepository.findAll());
        if(ObjectUtils.isEmpty(zoneRepository.findAll())) {
            for (BaseZone zone : BaseZone.values()) {
                ZoneCO zoneCO = new ZoneCO();
                zoneCO.setName(zone.getName());
                zoneService.saveZone(zoneCO);
            }
        }
        System.out.println("vendorRepository.findAll()>>>>>"+vendorRepository.findAll());
        if(ObjectUtils.isEmpty(vendorRepository.findAll())) {
            for (Vendor vendor : Vendor.values()) {
                VendorCO vendorCO = new VendorCO();
                vendorCO.setName(vendor.getName());
                vendorService.saveVendor(vendorCO);
            }
        }
    }
}
