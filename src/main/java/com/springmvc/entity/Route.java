package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String routeName;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Stop> stops;

    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Cab> cabs;

    @OneToMany(mappedBy = "route")
    private Set<CabRequest> cabRequests;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

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

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Set<Stop> getStops() {
        return stops;
    }

    public void setStops(Set<Stop> stops) {
        this.stops = stops;
    }

    public Set<CabRequest> getCabRequests() {
        return cabRequests;
    }

    public void setCabRequests(Set<CabRequest> cabRequests) {
        this.cabRequests = cabRequests;
    }

    public Set<Cab> getCabs() {
        return cabs;
    }

    public void setCabs(Set<Cab> cabs) {
        this.cabs = cabs;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", routeName='" + routeName + '\'' +
                '}';
    }
}
