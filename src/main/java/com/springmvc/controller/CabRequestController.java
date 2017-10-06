package com.springmvc.controller;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Route;
import com.springmvc.enums.CabRequestType;
import com.springmvc.repositories.RouteRepository;
import com.springmvc.service.CabRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    RouteRepository routeRepository;

    @RequestMapping(value = "/cancelCabRequest")
    @ResponseBody
    public String cancelCabRequest(Long cabRequestId){
        cabRequestService.cancelCabRequest(cabRequestId);
        return "Success";
    }

    @RequestMapping("/cabRequestSubmission")
    @ResponseBody
    public CabRequestCO cabRequestSubmission(CabRequestCO cabRequestCO){
        cabRequestService.saveCabRequest(cabRequestCO);
        return cabRequestCO;
    }

    @RequestMapping("/cabRequest")
    public ModelAndView cabRequest(){
        List<CabRequest> cabRequestList = cabRequestService.getCabRequestsForNewer();
        List<CabRequestType> cabRequestTypes = Arrays.asList(CabRequestType.values());
        ModelAndView modelAndView = new ModelAndView("cabRequest");
        modelAndView.addObject("routeList",routeRepository.findAll());
        modelAndView.addObject("cabRequestTypes",cabRequestTypes);
        modelAndView.addObject("cabRequestList",cabRequestList);
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
}
