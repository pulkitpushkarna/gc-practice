package com.springmvc.co;

import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Newer;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class FeedbackCO {

    private Newer initiator;

    private CabRequest cabRequest;

    private String feedback;

    public Newer getInitiator() {
        return initiator;
    }

    public FeedbackCO setInitiator(Newer initiator) {
        this.initiator = initiator;
        return this;
    }

    public CabRequest getCabRequest() {
        return cabRequest;
    }

    public FeedbackCO setCabRequest(CabRequest cabRequest) {
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
