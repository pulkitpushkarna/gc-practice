package com.springmvc.vo;

import java.util.Date;

public class RouteVO {
    private long routeId;
    private String name;
    private Date createdOn;
    private String zone;
    private String startPoint;
    private String endPoint;
    private String cabName;
    private int totalNewersInRoute;

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getTotalNewersInRoute() {
        return totalNewersInRoute;
    }

    public void setTotalNewersInRoute(int totalNewersInRoute) {
        this.totalNewersInRoute = totalNewersInRoute;
    }

    @Override
    public String toString() {
        return "RouteVO{" +
                "routeId=" + routeId +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
                ", zone='" + zone + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", cabName='" + cabName + '\'' +
                ", totalNewersInRoute=" + totalNewersInRoute +
                '}';
    }
}
