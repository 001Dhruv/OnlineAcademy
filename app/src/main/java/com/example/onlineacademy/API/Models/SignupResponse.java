package com.example.onlineacademy.API.Models;

public class SignupResponse {
    userSignup user;
    String token;

    public SignupResponse(userSignup user, String token) {
        this.user = user;
        this.token = token;
    }

    public userSignup getUser() {
        return user;
    }

    public void setUser(userSignup user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
