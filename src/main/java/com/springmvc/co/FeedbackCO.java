package com.springmvc.co;

public class FeedbackCO {

    private Long cabRequestId;

    private String comment;

    public Long getCabRequestId() {
        return cabRequestId;
    }

    public void setCabRequestId(Long cabRequestId) {
        this.cabRequestId = cabRequestId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "FeedbackCO{" +
                "cabRequestId=" + cabRequestId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
