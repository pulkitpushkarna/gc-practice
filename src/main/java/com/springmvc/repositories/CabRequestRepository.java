package com.springmvc.repositories;

import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Newer;
import com.springmvc.enums.CabRequestStatus;
import com.springmvc.enums.CabRequestType;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CabRequestRepository extends CrudRepository<CabRequest, Long>{

//    List<CabRequest> findAllByNewerAndCabRequestStatus(Newer newer, CabRequestStatus cabRequestStatus);

    List<CabRequest> findAllByCabRequestStatusAndCabRequestType(CabRequestStatus cabRequestStatus, CabRequestType cabRequestType);

    List<CabRequest> findAllByRequesterAndCabRequestStatusAndCabRequestType(Newer newer, CabRequestStatus cabRequestStatus, CabRequestType cabRequestType);
}
