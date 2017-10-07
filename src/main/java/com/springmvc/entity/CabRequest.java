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

    //    TODO: rename
    private Date travelDate;

    //    TODO: add zone id
    @OneToOne
    Feedback feedback;

    @ManyToOne
    private Zone zone;

    @OneToMany(mappedBy = "cabRequest")
    NewerRouteMapping newerRouteMapping;

    String pickUpLocation;

    String dropLocation;


    CabRequestType cabRequestType;

//    TODO: rename
    @ManyToOne
    Newer requester;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    @Enumerated(EnumType.STRING)
    private CabRequestStatus cabRequestStatus;

    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
