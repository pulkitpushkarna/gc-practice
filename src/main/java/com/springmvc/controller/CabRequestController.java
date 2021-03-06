package com.springmvc.controller;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Newer;
import com.springmvc.entity.Zone;
import com.springmvc.enums.CabRequestType;
import com.springmvc.repositories.ZoneRepository;
import com.springmvc.service.CabRequestService;
import com.springmvc.service.SpringSecurityService;
import com.springmvc.vo.CabRequestDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class CabRequestController {

    @Autowired
    CabRequestService cabRequestService;

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    SpringSecurityService springSecurityService;


    @RequestMapping("/checkWhetherUserHavePermanentRequest")
    @ResponseBody
    boolean checkWhetherUserHavePermanentRequest(){
        return cabRequestService.checkWhetherUserHavePermanentRequest();
    }

    @RequestMapping(value = "/cancelCabRequest")
    @ResponseBody
    public String cancelCabRequest(Long cabRequestId) {
        cabRequestService.cancelCabRequest(cabRequestId);
        return "Success";
    }

    @RequestMapping("/cabRequestSubmission")
    @ResponseBody
    public CabRequestCO cabRequestSubmission(CabRequestCO cabRequestCO){
        cabRequestService.saveCabRequest(cabRequestCO);
        return cabRequestCO;
    }

    @RequestMapping("/")
    public ModelAndView cabRequest(HttpSession httpSession) {
        Newer newer = springSecurityService.getCurrentUser();
        httpSession.setAttribute("profilePicUrl", newer.getProfilePicUrl());
        httpSession.setAttribute("userFullName", newer.getFirstName() + " " + newer.getLastName());
        List<CabRequestType> cabRequestTypes = Arrays.asList(CabRequestType.values());
        ModelAndView modelAndView = new ModelAndView("cabRequest");
        modelAndView.addObject("zoneList", zoneRepository.findAll());
        modelAndView.addObject("cabRequestTypes", cabRequestTypes);
        return modelAndView;
    }

    @RequestMapping("/permanentCabRequestsForApproval")
    public ModelAndView cabRequestForApproval() {
        ModelAndView modelAndView = new ModelAndView("permanentCabRequestsForApproval");
        List<CabRequest> cabRequestList = cabRequestService.getPermanentCabRequestsForApproval();
        modelAndView.addObject("cabRequestList", cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/adhocCabRequestsForApproval")
    public ModelAndView adhocCabRequestsForApproval() {
        ModelAndView modelAndView = new ModelAndView("adhocCabRequestsForApproval");
        List<CabRequest> cabRequestList = cabRequestService.adhocCabRequestsForApproval();
        modelAndView.addObject("cabRequestList", cabRequestList);
        return modelAndView;
    }


    @RequestMapping("/permanentCabRequestsApprovedByAdmin")
    public ModelAndView cabRequestApprovedByAdmin() {
        ModelAndView modelAndView = new ModelAndView("permanentCabRequestsApprovedByAdmin");
        List<CabRequest> cabRequestList = cabRequestService.getPermanentCabRequestsApprovedByAdmin();
        modelAndView.addObject("cabRequestList", cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/adhocCabRequestsApprovedByAdmin")
    public ModelAndView adhocCabRequestsApprovedByAdmin() {
        ModelAndView modelAndView = new ModelAndView("adhocCabRequestsForApproval");
        List<CabRequest> cabRequestList = cabRequestService.adhocCabRequestsApprovedByAdmin();
        modelAndView.addObject("cabRequestList", cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/rejectCabRequest")
    @ResponseBody
    public String rejectCabRequest(Long cabRequestId) {
        cabRequestService.rejectCabRequest(cabRequestId);
        return "Success";
    }

    @RequestMapping("/approveCabRequest")
    @ResponseBody
    public String approveCabRequest(Long cabRequestId, String details) {
        cabRequestService.approveCabRequest(cabRequestId, details);
        return "Success";
    }

    @RequestMapping("/pendingPermanentCabRequests")
    public ModelAndView pendingPermanentCabRequests() {
        ModelAndView modelAndView = new ModelAndView("pendingPermanentCabRequests");
        List<CabRequest> cabRequestList = cabRequestService.getPendingPermanentCabRequestsOfNewer();
        modelAndView.addObject("cabRequestList", cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/approvedPermanentCabRequests")
    public ModelAndView approvedPermanentCabRequests() {
        ModelAndView modelAndView = new ModelAndView("approvedPermanentCabRequests");
        List<CabRequest> cabRequestList = cabRequestService.getApprovedPermanentCabRequestsOfNewer();
        modelAndView.addObject("cabRequestList", cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/pendingAdhocCabRequests")
    public ModelAndView pendingAdhocCabRequests() {
        ModelAndView modelAndView = new ModelAndView("pendingAdhocCabRequests");
        List<CabRequest> cabRequestList = cabRequestService.getPendingAdhocCabRequestsOfNewer();
        modelAndView.addObject("cabRequestList", cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/approvedAdhocCabRequests")
    public ModelAndView approvedAdhocCabRequests() {
        ModelAndView modelAndView = new ModelAndView("approvedAdhocCabRequests");
        List<CabRequest> cabRequestList = cabRequestService.getApprovedAdhocCabRequestsOfNewer();
        modelAndView.addObject("cabRequestList", cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/cabRequestDetails/{cabRequestId}")
    public ModelAndView cabRequestDetails(@PathVariable("cabRequestId") long cabRequestId) {
        ModelAndView modelAndView = new ModelAndView("cabRequestDetails");
        CabRequestDetailsVO cabRequestDetailsVO = cabRequestService.fetchCabRequestDetails(cabRequestId);
        System.out.println(cabRequestDetailsVO);
        modelAndView.addObject("cabRequestDetailsVO", cabRequestDetailsVO);
        return modelAndView;
    }

    @RequestMapping("/approveOrRejectAdhocRequest/{cabRequestId}")
    public ModelAndView approveOrRejectAdhocRequest(@PathVariable("cabRequestId") long cabRequestId) {
        ModelAndView modelAndView = new ModelAndView("approveOrRejectAdhocRequest");
        modelAndView.addObject("cabRequest", cabRequestService.getCabRequestForId(cabRequestId));
        return modelAndView;
    }

    @RequestMapping("/approveOrRejectPermanentRequest/{cabRequestId}")
    public ModelAndView approveOrRejectPermanentRequest(@PathVariable("cabRequestId") long cabRequestId) {
        CabRequest cabRequest = cabRequestService.getCabRequestForId(cabRequestId);
        ModelAndView modelAndView = new ModelAndView("approveOrRejectPermanentRequest");
        Zone zone = cabRequest.getZone();
        modelAndView.addObject("cabRequest", cabRequest);
        modelAndView.addObject("routes", zone.getRoute());
        return modelAndView;
    }

    @RequestMapping("/approvePermanentRequest")
    @ResponseBody
    public String approvePermanentRequest(long routeId, long cabRequestId) {
        cabRequestService.approvePermanentCabRequest(routeId, cabRequestId);
        return "Success";
    }
}
