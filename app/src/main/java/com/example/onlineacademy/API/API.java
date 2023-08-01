package com.example.onlineacademy.API;

import com.example.onlineacademy.API.Models.LoginResponse;
import com.example.onlineacademy.API.Models.user;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {
    @POST("login")
    Call<ResponseBody> userLogin(@Query("email")String email, @Query("password") String password);
}
