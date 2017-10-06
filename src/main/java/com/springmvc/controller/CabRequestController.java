package com.springmvc.controller;

import com.springmvc.co.CabRequestCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.service.CabRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CabRequestController {

    @Autowired
    CabRequestService cabRequestService;

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
        ModelAndView modelAndView = new ModelAndView("cabRequest");
        modelAndView.addObject("cabRequestList",cabRequestList);
        return modelAndView;
    }

    @RequestMapping("/cabRequestsForApproval")
    public List<CabRequest> cabRequestForApproval(){
        List<CabRequest> cabRequestList = cabRequestService.getCabRequestsForApproval();
        return cabRequestList;
    }
}
