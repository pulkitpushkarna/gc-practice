package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "zone")
    List<CabRequest> cabRequestList = new ArrayList<>();

    @OneToMany(mappedBy = "zone")
    List<Route> route;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public List<CabRequest> getCabRequestList() {
        return cabRequestList;
    }

    public void setCabRequestList(List<CabRequest> cabRequestList) {
        this.cabRequestList = cabRequestList;
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zone setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
