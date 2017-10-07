package com.springmvc.repositories;

import com.springmvc.entity.CabRequest;
import com.springmvc.entity.NewerRouteMapping;
import org.springframework.data.repository.CrudRepository;

public interface NewerRouteMappingRepository extends CrudRepository<NewerRouteMapping, Long> {
}
