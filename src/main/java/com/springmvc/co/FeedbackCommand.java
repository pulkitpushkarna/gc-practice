package com.springmvc.co;

import com.springmvc.entity.Newer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * Created by diwakar on 02/10/17.
 */
public class FeedbackCommand {

    @NotNull
    private Date date;

    @NotNull
    private String driverName;

    private Newer newer;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Newer getNewer() {
        return newer;
    }

    public void setNewer(Newer newer) {
        this.newer = newer;
    }

    @Override
    public String toString() {
        return "FeedbackCommand{" +
                "date=" + date +
                ", driverName='" + driverName + '\'' +
                ", newer=" + newer +
                '}';
    }
}
