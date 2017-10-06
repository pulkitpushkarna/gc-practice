package com.springmvc.vo;

/**
 * Created by diwakar on 06/10/17.
 */
public class RouteListVO {
    private String name;
    private String startPoint;
    private String endPoint;
    private String cabName;

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

    @Override
    public String toString() {
        return "RouteListVO{" +
                "name='" + name + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", cabName='" + cabName + '\'' +
                '}';
    }
}
