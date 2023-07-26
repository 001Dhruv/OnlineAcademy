package com.example.onlineacademy;

public class HomeFragmentModel {
    String img;
    String title;
    String desc;
    String  prog;


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
