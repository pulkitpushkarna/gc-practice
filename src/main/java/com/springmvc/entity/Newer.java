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

    //    TODO: change to name
    private String firstName;

    private String lastName;

    private String email;

    private String reportingManagerEmail;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "requester")
    private List<CabRequest> cabRequests;

    @OneToMany(mappedBy = "newer")
    private List<NewerRouteMapping> newerRouteMapping;

    private boolean isPaying;

    private String profilePicUrl;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                ", cabRequests=" + cabRequests +
                ", creationTime=" + creationTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
