package com.springmvc.co;

import com.springmvc.entity.Cab;

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
    private String cabRegId;


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

    public String getCabRegId() {
        return cabRegId;
    }

    public void setCabRegId(String cabRegId) {
        this.cabRegId = cabRegId;
    }

    @Override
    public String toString() {
        return "RouteCommand{" +
                "routeName='" + routeName + '\'' +
                ", stops=" + stops +
                ", cab=" + cabRegId +
                '}';
    }
}
