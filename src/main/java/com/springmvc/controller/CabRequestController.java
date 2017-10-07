package com.springmvc.controller;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Route;
import com.springmvc.entity.Zone;
import com.springmvc.enums.CabRequestType;
import com.springmvc.repositories.CabRequestRepository;
import com.springmvc.repositories.RouteRepository;
import com.springmvc.repositories.ZoneRepository;
import com.springmvc.service.CabRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.List;

@Controller
public class CabRequestController {

    @Autowired
    CabRequestService cabRequestService;

    @Autowired
    ZoneRepository zoneRepository;

    @RequestMapping(value = "/cancelCabRequest")
    @ResponseBody
    public String cancelCabRequest(Long cabRequestId){
        cabRequestService.cancelCabRequest(cabRequestId);
        return "Success";
    }

    @RequestMapping("/cabRequestSubmission")
    @ResponseBody
    public CabRequestCO cabRequestSubmission(CabRequestCO cabRequestCO){
        System.out.println("In controller");
        cabRequestService.saveCabRequest(cabRequestCO);
        return cabRequestCO;
    }

    @RequestMapping("/")
    public ModelAndView cabRequest(){
        List<CabRequestType> cabRequestTypes = Arrays.asList(CabRequestType.values());
        ModelAndView modelAndView = new ModelAndView("cabRequest");
        modelAndView.addObject("zoneList",zoneRepository.findAll());
        modelAndView.addObject("cabRequestTypes",cabRequestTypes);
        return modelAndView;
    }

    @RequestMapping("/permanentCabRequestsForApproval")
    public ModelAndView cabRequestForApproval(){
        ModelAndView modelAndView = new ModelAndView("permanentCabRequestsForApproval");
        List<CabRequest> cabRequestList = cabRequestService.getPermanentCabRequestsForApproval();
        modelAndView.addObject("cabRequestList",cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/adhocCabRequestsForApproval")
    public ModelAndView adhocCabRequestsForApproval(){
        ModelAndView modelAndView = new ModelAndView("adhocCabRequestsForApproval");
        List<CabRequest> cabRequestList = cabRequestService.adhocCabRequestsForApproval();
        modelAndView.addObject("cabRequestList",cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/rejectCabRequest")
    @ResponseBody
    public String rejectCabRequest(Long cabRequestId){
        cabRequestService.rejectCabRequest(cabRequestId);
        return "Success";
    }

    @RequestMapping("/approveCabRequest")
    @ResponseBody
    public String approveCabRequest(Long cabRequestId){
        cabRequestService.approveCabRequest(cabRequestId);
        return "Success";
    }

    @RequestMapping("/approvedAdhocCabRequests")
    public ModelAndView approvedAdhocCabRequests(){
        ModelAndView modelAndView = new ModelAndView("approvedAdhocCabRequests");
        List<CabRequest> cabRequestList = cabRequestService.getApprovedAdhocCabRequestsOfNewer();
        modelAndView.addObject("cabRequestList",cabRequestList);
        return modelAndView;
    }

    @RequestMapping("approveOrRejectAdhocRequest/{cabRequestId}")
    public ModelAndView approveOrRejectAdhocRequest(@PathVariable("cabRequestId") long cabRequestId){
        ModelAndView modelAndView = new ModelAndView("approveOrRejectAdhocRequest");
        modelAndView.addObject("cabRequest",cabRequestService.getCabRequestForId(cabRequestId));
        System.out.println("cabRequestId>>>"+cabRequestId);
        return modelAndView;
    }

    @RequestMapping("approveOrRejectPermanentRequest/{cabRequestId}")
    public ModelAndView approveOrRejectPermanentRequest(@PathVariable("cabRequestId") long cabRequestId ){
        CabRequest cabRequest = cabRequestService.getCabRequestForId(cabRequestId);
        ModelAndView modelAndView = new ModelAndView("approveOrRejectPermanentRequest");
        Zone zone = cabRequest.getZone();
        System.out.println("zone>>>"+zone);
        System.out.println("zone.getRoute()>>>>>>>>"+zone.getRoute());
        modelAndView.addObject("cabRequest",cabRequest);
        modelAndView.addObject("routes",zone.getRoute());
        return modelAndView;
    }

    @RequestMapping("approvePermanentRequest")
    @ResponseBody
    public String approvePermanentRequest(long routeId, long cabRequestId){
        cabRequestService.approvePermanentCabRequest(routeId,cabRequestId);
        return "Success";
    }
}
