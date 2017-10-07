package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String feedback;

    @OneToOne
    CabRequest cabRequest;

    @ManyToOne
    Newer initiater;

    @OneToMany(mappedBy = "feedback")
    List<FeedbackComment> comments;

    @CreatedDate
    private Date creationTime;

    @LastModifiedDate
    private Date modificationTime;

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

    public String getFeedback() {
        return feedback;
    }

    public Feedback setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public CabRequest getCabRequest() {
        return cabRequest;
    }

    public Feedback setCabRequest(CabRequest cabRequest) {
        this.cabRequest = cabRequest;
        return this;
    }

    public Newer getInitiater() {
        return initiater;
    }

    public Feedback setInitiater(Newer initiater) {
        this.initiater = initiater;
        return this;
    }

    public Feedback setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
        return this;
    }

    public List<FeedbackComment> getComments() {
        return comments;
    }

    public Feedback setComments(List<FeedbackComment> comments) {
        this.comments = comments;
        return this;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                '}';
    }
}
