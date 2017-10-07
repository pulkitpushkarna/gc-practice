package com.springmvc.enums;

//TODO: PHASE -II : Remove hard coded and allow to Add/Edit from UI
public enum CabType {

    FOUR_SEATER("Four Seater"),
    SEVEN_SEATER("Seven Seater");

    private String name;

    CabType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
