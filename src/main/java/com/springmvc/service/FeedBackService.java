package com.springmvc.service;

import com.springmvc.co.FeedbackCO;
import com.springmvc.entity.Feedback;
import com.springmvc.entity.Newer;
import com.springmvc.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public void insertFeedBack(FeedbackCO feedbackCO) {
        if (feedbackCO != null) {
            Newer newer = feedbackCO.getNewer();
            Feedback feedback = new Feedback();
            feedback.setDate(feedbackCO.getDate());
            feedback.setNewer(newer);
            feedback.setCab(newer.getCab());
            feedbackRepository.save(feedback);
        }
    }
}
