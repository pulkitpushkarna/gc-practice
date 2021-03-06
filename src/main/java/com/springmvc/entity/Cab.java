package com.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springmvc.enums.CabType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //    TODO: change to enum (big/small or seater)
    @Enumerated(EnumType.STRING)
    private CabType cabType;

    private String vehicleRegNumber;

    private String vehicleModel;

    @JsonIgnore
    @OneToMany(mappedBy = "cab", cascade = CascadeType.PERSIST)
    private List<CabRouteMapping> cabRouteMappingList;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    public List<CabRouteMapping> getCabRouteMappingList() {
        return cabRouteMappingList;
    }

    public void setCabRouteMappingList(List<CabRouteMapping> cabRouteMappingList) {
        this.cabRouteMappingList = cabRouteMappingList;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CabType getCabType() {
        return cabType;
    }

    public void setCabType(CabType cabType) {
        this.cabType = cabType;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                ", cabType=" + cabType +
                ", vehicleRegNumber='" + vehicleRegNumber + '\'' +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
