package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String routeName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Stop> stops;

    @ManyToOne
    private Zone zone;

    @OneToMany(mappedBy = "route")
    List<NewerRouteMapping> newerRouteMapping;

    @OneToMany(mappedBy = "route")
    List<CabRouteMapping> cabRouteMapping;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    public Route setNewerRouteMapping(List<NewerRouteMapping> newerRouteMapping) {
        this.newerRouteMapping = newerRouteMapping;
        return this;
    }

    public List<CabRouteMapping> getCabRouteMapping() {
        return cabRouteMapping;
    }

    public Route setCabRouteMapping(List<CabRouteMapping> cabRouteMapping) {
        this.cabRouteMapping = cabRouteMapping;
        return this;
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

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
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

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", routeName='" + routeName + '\'' +
                ", stops=" + stops +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
