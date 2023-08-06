package com.example.onlineacademy.API.Models;

public class HomeResponse {

    int id;
    String course_name;
    String course_image;
    String course_description;
    String course_teacher_name;
    String created_at;
    String updated_at;

    public HomeResponse(int id, String course_name, String course_image, String course_description, String course_teacher_name, String created_at, String updated_at) {
        this.id = id;
        this.course_name = course_name;
        this.course_image = course_image;
        this.course_description = course_description;
        this.course_teacher_name = course_teacher_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_image() {
        return course_image;
    }

    public void setCourse_image(String course_image) {
        this.course_image = course_image;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_teacher_name() {
        return course_teacher_name;
    }

    public void setCourse_teacher_name(String course_teacher_name) {
        this.course_teacher_name = course_teacher_name;
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
}
