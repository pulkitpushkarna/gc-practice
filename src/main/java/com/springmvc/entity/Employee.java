package com.springmvc.entity;


import javax.persistence.*;

@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String newerId;

    String firstName;

    String lastName;

    @OneToOne
    Route route;

}
