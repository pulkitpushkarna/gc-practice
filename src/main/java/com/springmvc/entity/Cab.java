package com.springmvc.entity;

import javax.persistence.*;

@Entity
public class Cab {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer seater;

    String cabNumber;

    @OneToOne
    Route route;
}
