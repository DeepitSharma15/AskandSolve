package com.example.askandsolve;

import com.google.firebase.database.DataSnapshot;

import java.util.Date;

public class Questions {
    Integer QueId, views, votes;
    String title, queContent;
    boolean isAnswered, hasAcceptedAnswered;
    Date createdAt, updatedAt;
    Integer userId;
    Answer answer;
    User user;

    public Questions(Integer queId, Integer views, Integer votes, String title, String queContent,
                     boolean isAnswered, boolean hasAcceptedAnswered, Integer userId) {
        QueId = queId;
        this.views = views;
        this.votes = votes;
        this.title = title;
        this.queContent = queContent;
        this.isAnswered = isAnswered;
        this.hasAcceptedAnswered = hasAcceptedAnswered;
        this.userId = userId;
    }
    public Questions() {}

    public void setQueId(Integer queId) {
        QueId = queId;
    }

    public Integer getQueId() {
        return QueId;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getVotes() {
        return votes;
    }

    public String getTitle() {
        return title;
    }

    public String getQueContent() {
        return queContent;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public boolean isHasAcceptedAnswered() {
        return hasAcceptedAnswered;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQueContent(String queContent) {
        this.queContent = queContent;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public void setHasAcceptedAnswered(boolean hasAcceptedAnswered) {
        this.hasAcceptedAnswered = hasAcceptedAnswered;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
