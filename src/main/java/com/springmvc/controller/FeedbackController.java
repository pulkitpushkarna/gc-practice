package com.springmvc.controller;

import com.springmvc.co.FeedbackCO;
import com.springmvc.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("/addFeedbackComment")
    @ResponseBody
    public FeedbackCO cabRequestSubmission(FeedbackCO feedbackCO) {
        System.out.println("In controller");
        System.out.println(feedbackCO);
        feedbackService.createOrUpdateFeedBack(feedbackCO);
        return feedbackCO;
    }
}
