package com.springmvc.entity;

import javax.persistence.*;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String token;

    @OneToOne
    private Newer newer;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Newer getNewer() {
        return newer;
    }

    public void setNewer(Newer newer) {
        this.newer = newer;
    }
}
