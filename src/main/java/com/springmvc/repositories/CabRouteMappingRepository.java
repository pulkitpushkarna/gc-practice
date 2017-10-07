package com.springmvc.repositories;

import com.springmvc.entity.Cab;
import com.springmvc.entity.CabRouteMapping;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

/**
 * Created by diwakar on 07/10/17.
 */
public interface CabRouteMappingRepository extends CrudRepository<CabRouteMapping,Long> {
//    List<CabRouteMapping> findByIsActiveIsTrueAndRouteIsNull();
    CabRouteMapping findByCabAndIsActiveIsTrue(Cab cab);
    List<CabRouteMapping> findAllByCreationTimeBetween(Date startDate, Date endDate, Pageable pageable);
}
