package com.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by diwakar on 01/10/17.
 */
@Entity
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String stopName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "id=" + id +
                ", stopName='" + stopName + '\'' +
                '}';
    }
}
