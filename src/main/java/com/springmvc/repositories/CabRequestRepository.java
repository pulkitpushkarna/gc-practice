package com.springmvc.repositories;

import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Newer;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CabRequestRepository extends CrudRepository<CabRequest, Long>{

    List<CabRequest> findAllByNewer(Newer newer);
}
