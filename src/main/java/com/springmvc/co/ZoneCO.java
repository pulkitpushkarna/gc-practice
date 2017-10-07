package com.springmvc.co;

import org.springframework.format.annotation.DateTimeFormat;

public class ZoneCO {

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
