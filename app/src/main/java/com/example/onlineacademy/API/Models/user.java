package com.example.onlineacademy.API.Models;

public class user {
    int id;
    String name;
    String email;
    String email_varified_at;
    String created_at;
    String updated_at;
    String status;
    String token;
    int contact;
    int standard;

    public user(int id, String name, String email, String email_varified_at, String created_at, String updated_at, String status, String token,int standard,int contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.email_varified_at = email_varified_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
        this.token = token;
        this.standard=standard;
        this.contact=contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail_varified_at() {
        return email_varified_at;
    }

    public void setEmail_varified_at(String email_varified_at) {
        this.email_varified_at = email_varified_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }
}

