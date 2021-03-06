package com.springmvc.co;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springmvc.enums.CabType;

/**
 * Created by diwakar on 05/10/17.
 */
public class CabCommand {

    private String vehicleRegNo;
    private CabType cabType;
    private String cabModel;

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public CabType getCabType() {
        return cabType;
    }

    public void setCabType(CabType cabType) {
        this.cabType = cabType;
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
                ", capacity=" + cabType +
                ", cabModel='" + cabModel + '\'' +
                '}';
    }
}
