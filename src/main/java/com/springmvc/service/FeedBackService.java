package com.springmvc.service;

import com.springmvc.co.FeedbackCO;
import com.springmvc.entity.Feedback;
import com.springmvc.entity.Newer;
import com.springmvc.repositories.CabRequestRepository;
import com.springmvc.repositories.FeedbackRepository;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private NewerRepository newerRepository;

    @Autowired
    private CabRequestRepository cabRequestRepository;

    public void insertFeedBack(FeedbackCO feedbackCO) {
        if (feedbackCO != null) {
            Newer newer = newerRepository.findOne((long) feedbackCO.getInitiator());
            Feedback feedback = new Feedback();
            feedback.setInitiater(newer);
            feedback.setFeedback(feedbackCO.getFeedback());
            feedback.setCabRequest(cabRequestRepository.findOne((long) feedbackCO.getCabRequest()));
            feedbackRepository.save(feedback);
        }
    }
}
