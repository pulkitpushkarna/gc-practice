package com.springmvc.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class FeedbackComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    private Feedback feedback;

    private String comment;

    @ManyToOne
    private Newer commenter;

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

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Newer getCommenter() {
        return commenter;
    }

    public FeedbackComment setCommenter(Newer commenter) {
        this.commenter = commenter;
        return this;
    }

    public FeedbackComment setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
        return this;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", comment=" + comment +
                ", Feedback ID=" + feedback.getId() +
                '}';
    }
}
