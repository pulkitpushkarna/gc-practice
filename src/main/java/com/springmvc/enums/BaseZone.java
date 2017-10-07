package com.springmvc.enums;

//TODO: PHASE -II : Remove hard coded and allow to Add/Edit from UI
public enum BaseZone {

    NOIDA("Noida"),
    GURGAON("Gurgaon"),
    GHAZIABAD("Ghaziabad"),
    FARIDABAD("Faridabad"),
    NORTH_DELHI("North Delhi"),
    SOUTH_DELHI("South Delhi"),
    EAST_DELHI("East Delhi"),
    WEST_DELHI("West Delhi"),
    CENTRAL_DELHI("Central Delhi"),
    GREATER_NOIDA("Greater Noida");

    private String name;

    BaseZone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
