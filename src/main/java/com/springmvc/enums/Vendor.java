package com.springmvc.enums;

public enum Vendor {

    CITY_HEART("City Heart"),
    CAR_CART("Car Cart"),
    JSR("JSR"),
    RIDHI_TRAVELS("Ridhi Travels");

    private String name;

    Vendor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
