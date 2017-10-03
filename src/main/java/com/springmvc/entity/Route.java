package com.springmvc.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by diwakar on 01/10/17.
 */
@Entity
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
