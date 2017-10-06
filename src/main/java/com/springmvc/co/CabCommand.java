package com.springmvc.co;

/**
 * Created by diwakar on 05/10/17.
 */
public class CabCommand {

    private String vehicleRegNo;
    private int capacity;

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "CabCommand{" +
                "vehicleRegNo='" + vehicleRegNo + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
