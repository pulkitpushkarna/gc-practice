package com.springmvc.repositories;

import com.springmvc.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by diwakar on 02/10/17.
 */
@Repository
public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {
  Route findByRouteName(String routeName);
}
