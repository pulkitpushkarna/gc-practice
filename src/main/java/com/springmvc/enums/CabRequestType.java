package com.springmvc.enums;

public enum CabRequestType {

    AD_HOC("Ad-hoc"),
//    ONE_TIME("One-Time"),
    PERMANENT("Permanent");

    private String name;

    CabRequestType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
