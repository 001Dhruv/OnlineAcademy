package com.example.onlineacademy.API.Models;

public class LoginResponse {
    user user;
    String token;

    public LoginResponse(com.example.onlineacademy.API.Models.user user, String token) {
        this.user = user;
        this.token = token;
    }

    public com.example.onlineacademy.API.Models.user getUser() {
        return user;
    }

    public void setUser(com.example.onlineacademy.API.Models.user user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
