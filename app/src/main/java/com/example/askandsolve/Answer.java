package com.example.askandsolve;

import java.util.Date;

public class Answer {

    Integer id, downVote, upVote;
    String ans_content;
    boolean isAccepted;
    Date createdAt, updatedAt;
    Integer userId, questionId;
    User answeredBy;
    Questions questions;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDownVote(Integer downVote) {
        this.downVote = downVote;
    }

    public void setUpVote(Integer upVote) {
        this.upVote = upVote;
    }

    public void setAns_content(String ans_content) {
        this.ans_content = ans_content;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDownVote() {
        return downVote;
    }

    public Integer getUpVote() {
        return upVote;
    }

    public String getAns_content() {
        return ans_content;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
