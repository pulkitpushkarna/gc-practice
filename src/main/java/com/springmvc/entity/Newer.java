package com.springmvc.entity;

import com.springmvc.enums.UserRole;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Newer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long newerId;

    //    TODO: remove
    private String username;

    //    TODO: change to name
    private String firstName;

    private String lastName;

    private String email;

    //    TODO: Remove
    private String password;

    private String reportingManagerEmail;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;


    private String managerEmail;

    @OneToMany(mappedBy = "requester")
    private List<CabRequest> cabRequests;

    @OneToMany(mappedBy = "newer")
    private List<NewerRouteMapping> newerRouteMapping;

    private boolean isPaying;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    public boolean isPaying() {
        return isPaying;
    }

    public void setPaying(boolean paying) {
        isPaying = paying;
    }

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


    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getReportingManagerEmail() {
        return reportingManagerEmail;
    }

    public void setReportingManagerEmail(String reportingManagerEmail) {
        this.reportingManagerEmail = reportingManagerEmail;
    }

    public List<CabRequest> getCabRequests() {
        return cabRequests;
    }

    public void setCabRequests(List<CabRequest> cabRequests) {
        this.cabRequests = cabRequests;
    }


    public List<NewerRouteMapping> getNewerRouteMapping() {
        return newerRouteMapping;
    }

    public void setNewerRouteMapping(List<NewerRouteMapping> newerRouteMapping) {
        this.newerRouteMapping = newerRouteMapping;
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
                ", managerEmail=" + managerEmail +
                ", cabRequests=" + cabRequests +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
