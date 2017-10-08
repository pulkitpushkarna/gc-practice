package com.springmvc.service;

import com.springmvc.co.FeedbackCommentCO;
import com.springmvc.entity.FeedbackComment;
import com.springmvc.entity.Newer;
import com.springmvc.repositories.FeedbackCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackCommentService {

    @Autowired
    SpringSecurityService springSecurityService;
    @Autowired
    private FeedbackCommentRepository feedbackCommentRepository;

    public void addComment(FeedbackCommentCO feedbackCommentCO) {
        if (feedbackCommentCO != null) {
            FeedbackComment feedbackComment = new FeedbackComment();
            Newer newer = springSecurityService.getCurrentUser();
            feedbackComment.setCommenter(newer);
            feedbackComment.setFeedback(feedbackCommentCO.getFeedback());
            feedbackComment.setComment(feedbackCommentCO.getComment());
            feedbackCommentRepository.save(feedbackComment);
        }
    }
}
