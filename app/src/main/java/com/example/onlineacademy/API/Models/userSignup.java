package com.example.onlineacademy.API.Models;

public class userSignup {

    String name;
    String email;
    int standard;
    int contact;
    String updated_at;
    String created_at;
    int id;
    String token;

    public userSignup(String name, String email, int standard, int contact, String updated_at, String created_at, int id, String token) {
        this.name = name;
        this.email = email;
        this.standard = standard;
        this.contact = contact;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.id = id;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
