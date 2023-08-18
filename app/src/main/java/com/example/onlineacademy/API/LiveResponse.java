package com.example.onlineacademy.API;

public class LiveResponse {
    int id;
    int user_id;
    int course_id;
    String youtube_title;
    String youtube_image;
    String youtube_description;
    String youtube_video_url;
    String created_at;
    String updated_at;

    public LiveResponse(int id, int user_id, int course_id, String youtube_title, String youtube_image, String youtube_description, String youtube_video_url, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.course_id = course_id;
        this.youtube_title = youtube_title;
        this.youtube_image = youtube_image;
        this.youtube_description = youtube_description;
        this.youtube_video_url = youtube_video_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getYoutube_title() {
        return youtube_title;
    }

    public void setYoutube_title(String youtube_title) {
        this.youtube_title = youtube_title;
    }

    public String getYoutube_image() {
        return youtube_image;
    }

    public void setYoutube_image(String youtube_image) {
        this.youtube_image = youtube_image;
    }

    public String getYoutube_description() {
        return youtube_description;
    }

    public void setYoutube_description(String youtube_description) {
        this.youtube_description = youtube_description;
    }

    public String getYoutube_video_url() {
        return youtube_video_url;
    }

    public void setYoutube_video_url(String youtube_video_url) {
        this.youtube_video_url = youtube_video_url;
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

