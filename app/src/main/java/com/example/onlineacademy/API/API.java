package com.example.onlineacademy.API;



import com.example.onlineacademy.API.Models.ExploreResponse;
import com.example.onlineacademy.API.Models.HomeResponse;
import com.example.onlineacademy.API.Models.LoginResponse;
import com.example.onlineacademy.API.Models.LogoutResponse;
import com.example.onlineacademy.API.Models.SignupResponse;
import com.example.onlineacademy.API.Models.SubjectData;
import com.example.onlineacademy.API.Models.user;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {
    @POST("login")
    Call<ResponseBody> userLogin(@Query("email")String email, @Query("password") String password);
    @POST("registration")
    Call<SignupResponse> userRegistration(@Query("name")String name, @Query("email")String email, @Query("password")String password, @Query("standard") String standard, @Query("contact") String contact);
    @POST("logout")
    Call<LogoutResponse> userLogout(@Query("tokenpass") String tokenpass);
//    @POST("EditProfile")
//    Call<LogoinResponse> userLogout(@Query("tokenpass") String tokenpass);
    @GET("coursegetdata")
    Call<List<HomeResponse>> getHomeData();

    //Change url for explore
    @GET("coursegetdata")
    Call<List<ExploreResponse>> getExploreData();
    @POST("idcourseid")
    Call<List<SubjectData>> getSubjectData(@Query("course_id") int course_id);
    @GET("livedataget")
    Call<List<LiveResponse>> getLiveData();

}
