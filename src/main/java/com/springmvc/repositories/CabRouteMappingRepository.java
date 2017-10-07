package com.springmvc.repositories;

import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.Route;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.List;

/**
 * Created by jalajtagra on 07/10/17.
 */
public interface CabRouteMappingRepository extends PagingAndSortingRepository<CabRouteMapping,Long> {

    List<CabRouteMapping> findAllByCreationTimeBetween( Date startDate, Date endDate, Pageable pageable);


}
