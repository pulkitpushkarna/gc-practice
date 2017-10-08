package com.springmvc.repositories;

import com.springmvc.entity.Cab;
import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.Route;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by diwakar on 07/10/17.
 */

public interface CabRouteMappingRepository extends PagingAndSortingRepository<CabRouteMapping,Long> {

    List<CabRouteMapping> findAllByIsActiveAndCreationTimeBetween(Boolean isActive, Date startDate, Date endDate, Pageable pageable);
    CabRouteMapping findByCabAndIsActiveIsTrue(Cab cab);
    List<CabRouteMapping> findAllByCreationTimeBetween(Date startDate, Date endDate, Pageable pageable);
    CabRouteMapping findByRoute(Route route);
}
