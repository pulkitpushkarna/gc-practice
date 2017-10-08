package com.springmvc.entity;

import com.springmvc.enums.CabRequestStatus;
import com.springmvc.enums.CabRequestType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class CabRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date travelDate;

    @OneToOne
    private Feedback feedback;

    @ManyToOne
    private Zone zone;

    @OneToMany(mappedBy = "cabRequest")
    private List<NewerRouteMapping> newerRouteMapping;

    private String pickUpLocation;

    private String dropLocation;

    private String reason;

    private String details;

    @Enumerated(EnumType.STRING)
    private CabRequestType cabRequestType;

    @ManyToOne
    private Newer requester;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    @Enumerated(EnumType.STRING)
    private CabRequestStatus cabRequestStatus;

    private Date approvalDate;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<NewerRouteMapping> getNewerRouteMapping() {
        return newerRouteMapping;
    }

    public void setNewerRouteMapping(List<NewerRouteMapping> newerRouteMapping) {
        this.newerRouteMapping = newerRouteMapping;
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public CabRequestStatus getCabRequestStatus() {
        return cabRequestStatus;
    }

    public void setCabRequestStatus(CabRequestStatus cabRequestStatus) {
        this.cabRequestStatus = cabRequestStatus;
    }

    public Newer getRequester() {
        return requester;
    }

    public void setRequester(Newer requester) {
        this.requester = requester;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public CabRequest setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public CabRequest setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
        return this;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public CabRequest setFeedback(Feedback feedback) {
        this.feedback = feedback;
        return this;
    }

    public Zone getZone() {
        return zone;
    }

    public CabRequest setZone(Zone zone) {
        this.zone = zone;
        return this;
    }

    @Override
    public String toString() {
        return "CabRequest{" +
                "id=" + id +
                ", requester=" + requester +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                ", cabRequestType=" + cabRequestType +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                ", cabRequestStatus=" + cabRequestStatus +
                '}';
    }
}
