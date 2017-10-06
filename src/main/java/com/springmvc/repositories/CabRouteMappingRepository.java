package com.springmvc.repositories;

import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.Route;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.Month;
import java.util.List;

/**
 * Created by jalajtagra on 06/10/17.
 */
public interface CabRouteMappingRepository extends PagingAndSortingRepository<CabRouteMapping, Long> {

    List<CabRouteMapping> findAllByMonth(Month month, Pageable pageable);

    List<CabRouteMapping> findAllMappingsByMonth(Month month);

}
