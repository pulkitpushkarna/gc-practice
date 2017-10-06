package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by diwakar on 01/10/17.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String routeName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Stop> stops;

    @OneToOne(cascade = CascadeType.ALL)
    private Cab cab;

    @OneToMany(mappedBy = "requestRoute")
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

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public Set<CabRequest> getCabRequests() {
        return cabRequests;
    }

    public void setCabRequests(Set<CabRequest> cabRequests) {
        this.cabRequests = cabRequests;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", routeName='" + routeName + '\'' +
                '}';
    }
}
