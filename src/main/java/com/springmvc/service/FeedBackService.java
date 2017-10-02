package com.springmvc.service;

import com.springmvc.co.FeedbackCommand;
import com.springmvc.entity.Feedback;
import com.springmvc.entity.Newer;
import com.springmvc.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by diwakar on 02/10/17.
 */
@Service
public class FeedBackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public void insertFeedBack(FeedbackCommand feedbackCommand){
        if(feedbackCommand != null){
            Newer newer = feedbackCommand.getNewer();
            Feedback feedback = new Feedback();
            feedback.setDriverName(feedbackCommand.getDriverName());
            feedback.setDate(feedbackCommand.getDate());
            feedback.setNewer(newer);
            feedback.setCab(newer.getCab());
            feedbackRepository.save(feedback);
        }
    }
}
