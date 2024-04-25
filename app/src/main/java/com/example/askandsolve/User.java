package com.example.askandsolve;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class User extends RequestBody {
    String userId;
    String email, name, password, aboutMe;
    int answerGiven;
    Date dateJoined;

    // Login & Signup
    User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setAnswerGiven(int answerGiven) {
        this.answerGiven = answerGiven;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public int getAnswerGiven() {
        return answerGiven;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return null;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

    }
}
