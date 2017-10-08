package com.springmvc.co;

public class FeedbackCO {

    private int initiator;

    private int cabRequest;

    private String feedback;

    public int getInitiator() {
        return initiator;
    }

    public FeedbackCO setInitiator(int initiator) {
        this.initiator = initiator;
        return this;
    }

    public int getCabRequest() {
        return cabRequest;
    }

    public FeedbackCO setCabRequest(int cabRequest) {
        this.cabRequest = cabRequest;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public FeedbackCO setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }
}
