package com.example.onlineacademy.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Instance {
    public static Instance instance;
    public API apiinterface;
    String url="";
    Instance()

    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).build();
        apiinterface=retrofit.create(API.class);
    }
    public static Instance getInstance()
    {
        if(instance==null)
        {
            instance = new Instance();
        }
        return instance;
}
}