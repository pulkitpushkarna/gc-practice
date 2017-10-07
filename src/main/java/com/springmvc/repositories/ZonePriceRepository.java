package com.springmvc.repositories;

import com.springmvc.entity.Zone;
import com.springmvc.entity.ZonePrice;
import com.springmvc.enums.CabType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jalajtagra on 07/10/17.
 */
public interface ZonePriceRepository extends CrudRepository<ZonePrice, Long> {

    ZonePrice findByZoneAndCabType(Zone zone, CabType cabType);
}
