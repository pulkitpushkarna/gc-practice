package com.springmvc.co;


import com.springmvc.enums.CabRequestType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CabRequestCO {

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date travelDate;
    private String dropLocation;
    private String pickUpLocation;
    private Long zoneId;
    private CabRequestType cabRequestType;
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

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

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

}
