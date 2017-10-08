package com.springmvc.service;

import com.springmvc.co.FeedbackCO;
import com.springmvc.co.FeedbackCommentCO;
import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Feedback;
import com.springmvc.entity.Newer;
import com.springmvc.repositories.CabRequestRepository;
import com.springmvc.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    SpringSecurityService springSecurityService;
    @Autowired
    FeedbackCommentService feedbackCommentService;
    @Autowired
    private CabRequestRepository cabRequestRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    public void createOrUpdateFeedBack(FeedbackCO feedbackCO) {
        if (feedbackCO != null) {
            CabRequest cabRequest = cabRequestRepository.findOne(feedbackCO.getCabRequestId());
            Feedback feedback = feedbackRepository.findByCabRequest(cabRequest);
            if (feedback != null) {
                FeedbackCommentCO feedbackCommentCO = new FeedbackCommentCO();
                feedbackCommentCO.setFeedback(feedback);
                feedbackCommentCO.setComment(feedbackCO.getComment());
                feedbackCommentService.addComment(feedbackCommentCO);

            } else {
                feedback = new Feedback();
                Newer newer = springSecurityService.getCurrentUser();
                feedback.setInitiator(newer);
                feedback.setFeedback(feedbackCO.getComment());
                feedback.setCabRequest(cabRequest);
                feedbackRepository.save(feedback);
            }
        }
    }
}
