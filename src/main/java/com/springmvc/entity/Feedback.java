package com.springmvc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by diwakar on 02/10/17.
 */
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String driverName;

    @ManyToOne
    private Newer newer;

    @ManyToOne
    private Cab cab;

    @Temporal(TemporalType.DATE)
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Newer getNewer() {
        return newer;
    }

    public void setNewer(Newer newer) {
        this.newer = newer;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", driverName='" + driverName + '\'' +
                ", newer=" + newer +
                ", cab=" + cab +
                ", date=" + date +
                '}';
    }
}
