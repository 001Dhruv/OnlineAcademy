package com.example.onlineacademy.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Instance {
    public static Instance instance;
    public API apiinterface;
    public static String url="https://brahminnerbrain.com/online_tuition_class/public/index.php/api/";
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