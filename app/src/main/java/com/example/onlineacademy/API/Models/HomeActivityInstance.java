package com.example.onlineacademy.API.Models;

import com.example.onlineacademy.Homeactivity.Homeactivity;

public class HomeActivityInstance {
    private static Homeactivity homeActivity;

    public static Homeactivity getHomeActivity() {
        return homeActivity;
    }

    public static void setHomeActivity(Homeactivity activity) {
        homeActivity = activity;
    }
}
