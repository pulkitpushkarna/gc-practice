package com.springmvc.entity;

import javax.persistence.*;
import java.time.Month;

/**
 * Created by jalajtagra on 06/10/17.
 */
@Entity(name = "cab_route_mapping")
public class CabRouteMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Cab cab;

    @OneToOne
    private Route route;

    @Enumerated(EnumType.STRING)
    private Month month;


    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "CabRouteMapping{" +
                "cab=" + cab +
                ", route=" + route +
                ", month=" + month +
                '}';
    }
}
