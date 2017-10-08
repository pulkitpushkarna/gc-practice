package com.springmvc.controller;

import com.springmvc.co.FeedbackCO;
import com.springmvc.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedBackService feedBackService;

    @PostMapping("/submit")
    @ResponseBody
    public Boolean submit(FeedbackCO feedbackCO) {
        feedBackService.insertFeedBack(feedbackCO);
        return true;
    }
}
