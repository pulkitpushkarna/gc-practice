package com.springmvc.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by diwakar on 01/10/17.
 */
@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int maxCapacity;

    private String vehicleRegNumber;

    @OneToMany
    private Set<Attendance> attendances;

    @OneToMany
    private Set<Feedback> feedbacks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }

    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }



    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                ", maxCapacity=" + maxCapacity +
                ", vehicleRegNumber='" + vehicleRegNumber + '\'' +
                '}';
    }
}
