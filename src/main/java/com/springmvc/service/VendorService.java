package com.springmvc.service;

import com.springmvc.co.VendorCO;
import com.springmvc.entity.Vendor;
import com.springmvc.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    SpringSecurityService springSecurityService;

    public void saveVendor(VendorCO vendorCO) {
        Vendor vendor = new Vendor();
        vendor.setName(vendorCO.getName());
        vendor.setContactPersonName(vendorCO.getContactPersonName());
        vendor.setContact(vendorCO.getContact());
        vendorRepository.save(vendor);
    }
}
