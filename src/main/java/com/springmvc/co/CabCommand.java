package com.springmvc.co;

import com.springmvc.enums.CabType;

/**
 * Created by diwakar on 05/10/17.
 */
public class CabCommand {

    private String vehicleRegNo;
    private CabType capacity;
    private String cabModel;

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public CabType getCapacity() {
        return capacity;
    }

    public void setCapacity(CabType capacity) {
        this.capacity = capacity;
    }

    public String getCabModel() {
        return cabModel;
    }

    public void setCabModel(String cabModel) {
        this.cabModel = cabModel;
    }

    @Override
    public String toString() {
        return "CabCommand{" +
                "vehicleRegNo='" + vehicleRegNo + '\'' +
                ", capacity=" + capacity +
                ", cabModel='" + cabModel + '\'' +
                '}';
    }
}
