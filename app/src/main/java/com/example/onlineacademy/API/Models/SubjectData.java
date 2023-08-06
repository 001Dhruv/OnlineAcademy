package com.example.onlineacademy.API.Models;

public class SubjectData {
    int id;
    String course_id;
    String subject_name;
    String topic_name;
    String youtube_video_title;
    String youtube_video_url;
    String created_at;
    String updated_at;
    String status;

    public SubjectData(int id, String course_id, String subject_name, String topic_name, String youtube_video_title, String youtube_video_url, String created_at, String updated_at, String status) {
        this.id = id;
        this.course_id = course_id;
        this.subject_name = subject_name;
        this.topic_name = topic_name;
        this.youtube_video_title = youtube_video_title;
        this.youtube_video_url = youtube_video_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getYoutube_video_title() {
        return youtube_video_title;
    }

    public void setYoutube_video_title(String youtube_video_title) {
        this.youtube_video_title = youtube_video_title;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
