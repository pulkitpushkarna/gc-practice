package com.springmvc.entity;

import javax.persistence.*;

@Entity
public class Stop {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @OneToOne
    Cab cab;
}
