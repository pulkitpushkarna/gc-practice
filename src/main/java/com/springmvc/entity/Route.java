package com.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {

    @Id
    Integer id;

    String name;


}
