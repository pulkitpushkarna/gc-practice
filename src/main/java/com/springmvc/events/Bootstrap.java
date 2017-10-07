package com.springmvc.events;

import com.springmvc.co.VendorCO;
import com.springmvc.co.ZoneCO;
import com.springmvc.enums.BaseZone;
import com.springmvc.enums.Vendor;
import com.springmvc.service.VendorService;
import com.springmvc.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {

    @Autowired
    ZoneService zoneService;
    @Autowired
    VendorService vendorService;

    @EventListener(ContextRefreshedEvent.class)
    void startUpEvent() {
        for (BaseZone zone : BaseZone.values()) {
            ZoneCO zoneCO = new ZoneCO();
            zoneCO.setName(zone.getName());
            zoneService.saveZone(zoneCO);
        }
        for (Vendor vendor : Vendor.values()) {
            VendorCO vendorCO = new VendorCO();
            vendorCO.setName(vendor.getName());
            vendorService.saveVendor(vendorCO);
        }

    }

}
