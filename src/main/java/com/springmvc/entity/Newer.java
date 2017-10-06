package com.springmvc.entity;

import com.springmvc.enums.UserRole;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Newer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long newerId;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole ;

    @ManyToMany
    private List<Route> newerRoutes;

    private long managerEmpId;

    @ManyToOne
    private Cab cab;

    @OneToMany(mappedBy = "newer")
    private Set<CabRequest> cabRequests;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getNewerId() {
        return newerId;
    }

    public void setNewerId(long newerId) {
        this.newerId = newerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Route> getRoute() {
        return newerRoutes;
    }

    public void setRoute(List<Route> route) {
        this.newerRoutes = route;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public List<Route> getNewerRoutes() {
        return newerRoutes;
    }

    public void setNewerRoutes(List<Route> newerRoutes) {
        this.newerRoutes = newerRoutes;
    }

    public Set<CabRequest> getCabRequests() {
        return cabRequests;
    }

    public void setCabRequests(Set<CabRequest> cabRequests) {
        this.cabRequests = cabRequests;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getManagerEmpId() {
        return managerEmpId;
    }

    public void setManagerEmpId(long managerEmpId) {
        this.managerEmpId = managerEmpId;
    }

    @Override
    public String toString() {
        return "Newer{" +
                "id=" + id +
                ", newerId=" + newerId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", newerRoutes=" + newerRoutes +
                ", managerEmpId=" + managerEmpId +
                ", cab=" + cab +
                ", cabRequests=" + cabRequests +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
