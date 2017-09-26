package com.springmvc.entity;

import com.springmvc.enums.UserRole;

import javax.persistence.*;

/**
 * Created by diwakar on 17/09/17.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", userRole=" + userRole +
                '}';
    }
}
