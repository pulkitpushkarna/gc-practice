package com.springmvc.service;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Newer;
import com.springmvc.enums.CabRequestStatus;
import com.springmvc.enums.CabRequestType;
import com.springmvc.repositories.CabRequestRepository;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        cabRequest.setCabRequestType(cabRequestCO.getCabRequestType());
        cabRequest.setNewer(springSecurityService.getCurrentUser());
        cabRequestRepository.save(cabRequest);
    }

    public List<CabRequest> getCabRequestsForNewer(){
        Newer newer = springSecurityService.getCurrentUser();
        return cabRequestRepository.findAllByNewerAndCabRequestStatus(newer,CabRequestStatus.APPLIED);
    }

    public void cancelCabRequest(Long cabRequestId){
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        cabRequest.setCabRequestStatus(CabRequestStatus.CANCEL);
        cabRequestRepository.save(cabRequest);
    }

    public List<CabRequest> getPermanentCabRequestsForApproval(){
        List<CabRequest> cabRequestList = cabRequestRepository.findAllByCabRequestStatusAndCabRequestType(CabRequestStatus.APPLIED, CabRequestType.PERMANENT);
        return cabRequestList;
    }

    public List<CabRequest> adhocCabRequestsForApproval(){
        List<CabRequest> cabRequestList = cabRequestRepository.findAllByCabRequestStatusAndCabRequestType(CabRequestStatus.APPLIED, CabRequestType.AD_HOC);
        return cabRequestList;
    }

    public void rejectCabRequest(Long cabRequestId){
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        cabRequest.setCabRequestStatus(CabRequestStatus.REJECTED);
        cabRequestRepository.save(cabRequest);
    }

    public void approveCabRequest(Long cabRequestId){
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        if(cabRequest.getCabRequestType().equals(CabRequestType.PERMANENT)){
            cabRequest.setApprovalDate(new Date());
        }
        cabRequest.setActive(true);
        cabRequest.setCabRequestStatus(CabRequestStatus.APPROVED);
        cabRequestRepository.save(cabRequest);
    }

    public List<CabRequest> getApprovedAdhocCabRequestsOfNewer(){
        Newer newer = springSecurityService.getCurrentUser();
        return cabRequestRepository.findAllByNewerAndCabRequestStatusAndCabRequestType(newer,CabRequestStatus.APPROVED,CabRequestType.AD_HOC);
    }
}
