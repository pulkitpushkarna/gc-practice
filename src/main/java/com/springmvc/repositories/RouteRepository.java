package com.springmvc.repositories;

import com.springmvc.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by diwakar on 02/10/17.
 */
@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
}
