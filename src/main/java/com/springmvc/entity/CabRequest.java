package com.springmvc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by diwakar on 02/10/17.
 */
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
    private Newer requester;

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
                '}';
    }
}
