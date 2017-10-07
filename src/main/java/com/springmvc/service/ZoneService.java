package com.springmvc.service;

import com.springmvc.co.ZoneCO;
import com.springmvc.entity.Zone;
import com.springmvc.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneService {

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    SpringSecurityService springSecurityService;

    public void saveZone(ZoneCO zoneCO) {
        Zone zone = new Zone();
        zone.setName(zoneCO.getName());
        zoneRepository.save(zone);
    }
}
