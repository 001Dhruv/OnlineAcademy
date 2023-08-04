package com.example.onlineacademy.Homeactivity.Models;

public class HomeFragmentModel {
    public String img;
    public String title;
    public String desc;
    public String  prog;


    public HomeFragmentModel(String img, String title, String desc) {
        this.img = img;
        this.title = title;
        this.desc = desc;
    }

    public HomeFragmentModel(String title, String desc, String prog, String img) {
        this.title = title;
        this.desc = desc;
        this.prog = prog;
        this.img=img;
    }
}
