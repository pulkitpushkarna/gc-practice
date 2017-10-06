package com.springmvc.entity;

import com.springmvc.enums.CabRequestStatus;
import com.springmvc.enums.CabRequestType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class CabRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date requestDate;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Newer newer;

    private String pickUpLocation;

    private String dropLocation;

    private String projectName;

    private String managerName;

    @Enumerated(EnumType.STRING)
    private CabRequestType cabRequestType;

    private Date approvalDate;

    private Date unavailingDate;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    @Enumerated(EnumType.STRING)
    private CabRequestStatus cabRequestStatus;

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getUnavailingDate() {
        return unavailingDate;
    }

    public void setUnavailingDate(Date unavailingDate) {
        this.unavailingDate = unavailingDate;
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

    public Newer getNewer() {
        return newer;
    }

    public void setNewer(Newer newer) {
        this.newer = newer;
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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "CabRequest{" +
                "id=" + id +
                ", requestDate=" + requestDate +
                ", route=" + route +
                ", newer=" + newer +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                ", projectName='" + projectName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", cabRequestType=" + cabRequestType +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                ", cabRequestStatus=" + cabRequestStatus +
                '}';
    }
}
