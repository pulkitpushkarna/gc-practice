package com.springmvc.vo;

import com.springmvc.entity.CabRequest;
import com.springmvc.entity.Feedback;
import com.springmvc.enums.CabRequestType;

public class CabRequestDetailsVO {
    private CabRequest cabRequest;
    private Feedback feedback;
    private Boolean showingdetailsForRequester;

    public CabRequest getCabRequest() {
        return cabRequest;
    }

    public void setCabRequest(CabRequest cabRequest) {
        this.cabRequest = cabRequest;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Boolean isRequestAdhoc() {
        return cabRequest.getCabRequestType().equals(CabRequestType.AD_HOC);
    }

    public Boolean getShowingdetailsForRequester() {
        return showingdetailsForRequester;
    }

    public void setShowingdetailsForRequester(Boolean showingdetailsForRequester) {
        this.showingdetailsForRequester = showingdetailsForRequester;
    }

    @Override
    public String toString() {
        return "CabRequestDetailsVO{" +
                "cabRequest=" + cabRequest.getId() +
                (feedback != null ? ", feedbacks=" + feedback.getFeedback() : "") +
                ", isAdHocRequest=" + isRequestAdhoc() +
                " is requester = " + showingdetailsForRequester +
                '}';
    }
}
