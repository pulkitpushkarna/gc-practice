package com.springmvc.co;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * Created by diwakar on 02/10/17.
 */
public class RouteCommand {

    @NotNull
    private String routeName;

    @NotNull
    private List<String> stops;

    @NotNull
    private String cabRegNo;

    @NotNull
    private int maxCapacity;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public List<String> getStops() {
        return stops;
    }

    public void setStops(List<String> stops) {
        this.stops = stops;
    }

    public String getCabRegNo() {
        return cabRegNo;
    }

    public void setCabRegNo(String cabRegNo) {
        this.cabRegNo = cabRegNo;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "RouteCommand{" +
                "routeName='" + routeName + '\'' +
                ", stops=" + stops +
                ", cabRegNo='" + cabRegNo + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
