package com.springmvc.co;

import com.springmvc.entity.Feedback;

public class FeedbackCommentCO {

    private Feedback feedback;
    private String comment;

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "FeedbackCommentCO{" +
                "feedback=" + feedback.getId() +
                ", comment='" + comment + '\'' +
                '}';
    }
}
