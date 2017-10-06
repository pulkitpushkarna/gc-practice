package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by diwakar on 01/10/17.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String stopName;

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
