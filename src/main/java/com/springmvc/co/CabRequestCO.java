package com.springmvc.co;


import com.springmvc.enums.CabRequestType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CabRequestCO {

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date pickUpDate;
    private String dropLocation;
    private String pickUpLocation;
    private String projectName;
    private String projectManager;
    private CabRequestType cabRequestType;

    public CabRequestType getCabRequestType() {
        return cabRequestType;
    }

    public void setCabRequestType(CabRequestType cabRequestType) {
        this.cabRequestType = cabRequestType;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

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
