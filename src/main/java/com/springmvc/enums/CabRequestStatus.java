package com.springmvc.enums;

public enum CabRequestStatus {
    APPLIED("Applied"),
    REJECTED("Rejected"),
    CANCELED("Cancelled"),
    APPROVED("Apporoved");

    private String name;

    CabRequestStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
