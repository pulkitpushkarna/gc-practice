package com.springmvc.co;

import com.springmvc.entity.Newer;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class FeedbackCO {

    @NotNull
    private Date date;

    private Newer newer;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Newer getNewer() {
        return newer;
    }

    public void setNewer(Newer newer) {
        this.newer = newer;
    }

    @Override
    public String toString() {
        return "FeedbackCO{" +
                "date=" + date +
                ", newer=" + newer +
                '}';
    }
}
