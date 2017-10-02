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
    private Set<Long> stopIds;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Set<Long> getStopIds() {
        return stopIds;
    }

    public void setStopIds(Set<Long> stopIds) {
        this.stopIds = stopIds;
    }

    @Override
    public String toString() {
        return "RouteCommand{" +
                "routeName='" + routeName + '\'' +
                ", stopIds=" + stopIds +
                '}';
    }
}
