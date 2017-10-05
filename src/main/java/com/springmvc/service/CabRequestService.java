package com.springmvc.service;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Newer;
import com.springmvc.enums.CabRequestStatus;
import com.springmvc.repositories.CabRequestRepository;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabRequestService {

    @Autowired
    CabRequestRepository cabRequestRepository;

    @Autowired
    SpringSecurityService springSecurityService;

    public void saveCabRequest(CabRequestCO cabRequestCO){
        CabRequest cabRequest = new CabRequest();
        cabRequest.setDropLocation(cabRequestCO.getDropLocation());
        cabRequest.setManagerName(cabRequestCO.getProjectManager());
        cabRequest.setRequestDate(cabRequestCO.getPickUpDate());
        cabRequest.setProjectName(cabRequestCO.getProjectName());
        cabRequest.setCabRequestStatus(CabRequestStatus.APPLIED);
        cabRequest.setNewer(springSecurityService.getCurrentUser());
        cabRequestRepository.save(cabRequest);
    }

    public List<CabRequest> getCabRequestsForNewer(){
        Newer newer = springSecurityService.getCurrentUser();
        return cabRequestRepository.findAllByNewer(newer);
    }

    public void cancelCabRequest(Long cabRequestId){
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        cabRequest.setCabRequestStatus(CabRequestStatus.CANCEL);
        cabRequestRepository.save(cabRequest);
    }
}
