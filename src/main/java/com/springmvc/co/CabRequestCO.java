package com.springmvc.co;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CabRequestCO {

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date pickUpDate;
    private String dropLocation;
    private String projectName;
    private String projectManager;

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
}
