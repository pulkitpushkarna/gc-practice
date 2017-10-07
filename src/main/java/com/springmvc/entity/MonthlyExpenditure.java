package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class MonthlyExpenditure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    long amountSpend;

    long amountRecieved;

    @ManyToOne
    CabRouteMapping cabRouteMapping;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

}
