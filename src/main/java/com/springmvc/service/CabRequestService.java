package com.springmvc.service;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.*;
import com.springmvc.enums.CabRequestStatus;
import com.springmvc.enums.CabRequestType;
import com.springmvc.repositories.*;
import com.springmvc.vo.CabRequestDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
public class CabRequestService {

    @Autowired
    CabRequestRepository cabRequestRepository;
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    SpringSecurityService springSecurityService;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    NewerRouteMappingRepository newerRouteMappingRepository;

    public boolean checkWhetherUserHavePermanentRequest(){
        boolean resultValue = true;
        Newer newer = springSecurityService.getCurrentUser();
        List<CabRequest> cabRequestList=cabRequestRepository.findAllByRequesterAndCabRequestType(newer, CabRequestType.PERMANENT);
        if(ObjectUtils.isEmpty(cabRequestList)){
            resultValue = false;
        }
        return resultValue;
    }

    public void saveCabRequest(CabRequestCO cabRequestCO) {
        CabRequest cabRequest = new CabRequest();
        cabRequest.setDropLocation(cabRequestCO.getDropLocation());
        cabRequest.setPickUpLocation(cabRequestCO.getPickUpLocation());
        cabRequest.setCabRequestStatus(CabRequestStatus.APPLIED);
        cabRequest.setCabRequestType(cabRequestCO.getCabRequestType());
        cabRequest.setRequester(springSecurityService.getCurrentUser());
        if (cabRequestCO.getZoneId() != null) {
            Zone zone = zoneRepository.findOne(cabRequestCO.getZoneId());
            cabRequest.setZone(zone);
            zone.getCabRequestList().add(cabRequest);
            zoneRepository.save(zone);
        } else {
            cabRequest.setTravelDate(cabRequestCO.getTravelDate());
            cabRequest.setReason(cabRequestCO.getReason());
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

    public void approveCabRequest(Long cabRequestId, String details) {
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        cabRequest.setDetails(details);
        cabRequest.setCabRequestStatus(CabRequestStatus.APPROVED);
        cabRequestRepository.save(cabRequest);
    }

    public List<CabRequest> getPendingAdhocCabRequestsOfNewer() {
        Newer newer = springSecurityService.getCurrentUser();
        return cabRequestRepository.findAllByRequesterAndCabRequestStatusAndCabRequestType(newer, CabRequestStatus.APPLIED, CabRequestType.AD_HOC);
    }

    public List<CabRequest> getApprovedAdhocCabRequestsOfNewer() {
        Newer newer = springSecurityService.getCurrentUser();
        return cabRequestRepository.findAllByRequesterAndCabRequestStatusAndCabRequestType(newer, CabRequestStatus.APPROVED, CabRequestType.AD_HOC);
    }

    public List<CabRequest> getPendingPermanentCabRequestsOfNewer() {
        Newer newer = springSecurityService.getCurrentUser();
        return cabRequestRepository.findAllByRequesterAndCabRequestStatusAndCabRequestType(newer, CabRequestStatus.APPLIED, CabRequestType.PERMANENT);
    }

    public List<CabRequest> getApprovedPermanentCabRequestsOfNewer() {
        Newer newer = springSecurityService.getCurrentUser();
        return cabRequestRepository.findAllByRequesterAndCabRequestStatusAndCabRequestType(newer, CabRequestStatus.APPROVED, CabRequestType.PERMANENT);
    }

    public CabRequestDetailsVO fetchCabRequestDetails(Long cabRequestId) {
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        CabRequestDetailsVO cabRequestDetailsVO = new CabRequestDetailsVO();
        cabRequestDetailsVO.setCabRequest(cabRequest);
        cabRequestDetailsVO.setFeedback(feedbackRepository.findByCabRequest(cabRequest));
        cabRequestDetailsVO.setShowingdetailsForRequester(cabRequest.getRequester().getId() == springSecurityService.getCurrentUser().getId());
        return cabRequestDetailsVO;
    }

    public CabRequest getCabRequestForId(long cabRequestId) {
        return cabRequestRepository.findOne(cabRequestId);
    }

    public void approvePermanentCabRequest(long routeId, long cabRequestId) {
        Route route = routeRepository.findOne(routeId);
        CabRequest cabRequest = cabRequestRepository.findOne(cabRequestId);
        cabRequest.setCabRequestStatus(CabRequestStatus.APPROVED);
        cabRequestRepository.save(cabRequest);
        Newer requester = cabRequest.getRequester();
        NewerRouteMapping newerRouteMapping = new NewerRouteMapping();
        newerRouteMapping.setRoute(route);
        newerRouteMapping.setNewer(requester);
        newerRouteMapping.setCabRequest(cabRequest);
        newerRouteMapping.setJoinedDate(new Date());
        newerRouteMapping.setActive(true);
        newerRouteMappingRepository.save(newerRouteMapping);
    }
}
