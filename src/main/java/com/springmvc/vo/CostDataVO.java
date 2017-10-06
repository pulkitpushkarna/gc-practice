package com.springmvc.vo;

import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.Newer;

import java.util.List;

/**
 * Created by jalajtagra on 07/10/17.
 */
public class CostDataVO {

    private CabRouteMapping cabRouteMapping;
    private Integer numberOfCabbies;

    public CabRouteMapping getCabRouteMapping() {
        return cabRouteMapping;
    }

    public void setCabRouteMapping(CabRouteMapping cabRouteMapping) {
        this.cabRouteMapping = cabRouteMapping;
    }

    public Integer getNumberOfCabbies() {
        return numberOfCabbies;
    }

    public void setNumberOfCabbies(Integer numberOfCabbies) {
        this.numberOfCabbies = numberOfCabbies;
    }
}
