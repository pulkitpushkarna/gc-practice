package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Month;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class MonthlyExpenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    long amountSpend;

    long amountRecieved;

    @Enumerated(EnumType.STRING)
    Month month;

    @ManyToOne
    CabRouteMapping cabRouteMapping;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    public long getId() {
        return id;
    }

    public MonthlyExpenditure setId(long id) {
        this.id = id;
        return this;
    }

    public long getAmountSpend() {
        return amountSpend;
    }

    public MonthlyExpenditure setAmountSpend(long amountSpend) {
        this.amountSpend = amountSpend;
        return this;
    }

    public long getAmountRecieved() {
        return amountRecieved;
    }

    public MonthlyExpenditure setAmountRecieved(long amountRecieved) {
        this.amountRecieved = amountRecieved;
        return this;
    }

    public CabRouteMapping getCabRouteMapping() {
        return cabRouteMapping;
    }

    public MonthlyExpenditure setCabRouteMapping(CabRouteMapping cabRouteMapping) {
        this.cabRouteMapping = cabRouteMapping;
        return this;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public MonthlyExpenditure setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public MonthlyExpenditure setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
        return this;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
