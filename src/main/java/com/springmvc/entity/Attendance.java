package com.springmvc.entity;

import com.springmvc.enums.AttendanceStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Attendance {

    @Id
    Integer id;

    @Temporal(TemporalType.DATE)
    Date date;

    AttendanceStatus attendanceStatus;

    @ManyToOne
    Employee employee;

    @ManyToOne
    Cab cab;
}
