package com.springmvc.co;

import org.springframework.format.annotation.DateTimeFormat;

public class VendorCO {

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String name;
    private String contactPersonName;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
