package com.springmvc.service;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Newer;
import com.springmvc.entity.Zone;
import com.springmvc.enums.CabRequestStatus;
import com.springmvc.enums.CabRequestType;
import com.springmvc.repositories.CabRequestRepository;
import com.springmvc.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabRequestService {

    @Autowired
    CabRequestRepository cabRequestRepository;

    @Autowired
    SpringSecurityService springSecurityService;

    @Autowired
    ZoneRepository zoneRepository;

    public void saveCabRequest(CabRequestCO cabRequestCO) {
        CabRequest cabRequest = new CabRequest();
        cabRequest.setDropLocation(cabRequestCO.getDropLocation());
        cabRequest.setPickUpLocation(cabRequestCO.getPickUpLocation());
        cabRequest.setCabRequestStatus(CabRequestStatus.APPLIED);
        cabRequest.setCabRequestType(cabRequestCO.getCabRequestType());
        cabRequest.setRequester(springSecurityService.getCurrentUser());
        if(cabRequestCO.getZoneId()!=null) {
            Zone zone = zoneRepository.findOne(cabRequestCO.getZoneId());
            cabRequest.setZone(zone);
            zone.getCabRequestList().add(cabRequest);
            zoneRepository.save(zone);
        }else{
            cabRequest.setTravelDate(cabRequestCO.getTravelDate());
        }
        cabRequestRepository.save(cabRequest);
    }

    public List<CabRequest> getCabRequestsForNewer() {
        Newer newer = springSecurityService.getCurrentUser();
        return null;
    }

    public void cancelCabRequest(Long cabRequestId) {
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        cabRequest.setCabRequestStatus(CabRequestStatus.CANCELED);
        cabRequestRepository.save(cabRequest);
    }

    public List<CabRequest> getPermanentCabRequestsForApproval() {
        List<CabRequest> cabRequestList = cabRequestRepository.findAllByCabRequestStatusAndCabRequestType(CabRequestStatus.APPLIED, CabRequestType.PERMANENT);
        return cabRequestList;
    }

    public List<CabRequest> adhocCabRequestsForApproval() {
        List<CabRequest> cabRequestList = cabRequestRepository.findAllByCabRequestStatusAndCabRequestType(CabRequestStatus.APPLIED, CabRequestType.AD_HOC);
        return cabRequestList;
    }

    public void rejectCabRequest(Long cabRequestId) {
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        cabRequest.setCabRequestStatus(CabRequestStatus.REJECTED);
        cabRequestRepository.save(cabRequest);
    }

    public void approveCabRequest(Long cabRequestId) {
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        if (cabRequest.getCabRequestType().equals(CabRequestType.PERMANENT)) {
//            cabRequest.setApprovalDate(new Date());
        }
        cabRequest.setCabRequestStatus(CabRequestStatus.APPROVED);
        cabRequestRepository.save(cabRequest);
    }

    public List<CabRequest> getApprovedAdhocCabRequestsOfNewer() {
        Newer newer = springSecurityService.getCurrentUser();
        return null;
    }

    public CabRequest getCabRequestForId(long cabRequestId){
        return cabRequestRepository.findOne(cabRequestId);
    }
}
