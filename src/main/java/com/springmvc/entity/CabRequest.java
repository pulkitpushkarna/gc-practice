package com.springmvc.entity;

import com.springmvc.enums.CabRequestStatus;

import javax.persistence.*;
import java.util.Date;


@Entity
public class CabRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date requestDate;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Newer newer;

    private String dropLocation;

    private String projectName;

    private String managerName;

    @Enumerated(EnumType.STRING)
    private CabRequestStatus cabRequestStatus;

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
                ", dropLocation='" + dropLocation + '\'' +
                ", projectName='" + projectName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", cabRequestStatus=" + cabRequestStatus +
                '}';
    }
}
