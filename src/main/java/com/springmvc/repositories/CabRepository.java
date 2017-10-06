package com.springmvc.repositories;

import com.springmvc.entity.Cab;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by diwakar on 02/10/17.
 */
@Repository
public interface CabRepository extends PagingAndSortingRepository<Cab, Long> {

    Cab findByVehicleRegNumber(String vehicleRegNo);

}
