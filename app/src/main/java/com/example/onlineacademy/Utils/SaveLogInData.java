package com.example.onlineacademy.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;

import com.example.onlineacademy.API.Models.user;
import com.example.onlineacademy.LoginActivity;

public class SaveLogInData {
    public static void saveLogInData(user loginres, Context context){
        SharedPreferences preferences = context.getSharedPreferences("loginPrefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.putString("email",loginres.getEmail());
        editor.putString("token",loginres.getToken());
        editor.putString("name",loginres.getName());
        editor.putString("email_varified_at",loginres.getEmail_varified_at());
        editor.putString("created_at",loginres.getCreated_at());
        editor.putString("updated_at",loginres.getUpdated_at());
        editor.putString("status",loginres.getStatus());
        editor.putInt("id",loginres.getId());
        editor.apply();
    }
    public static void logOutUser(View view) {
        SharedPreferences preferences =view.getContext().getSharedPreferences("loginPrefs",view.getContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
//        editor.putBoolean("isLoggedIn",false);
        editor.remove("isLoggedIn");
        editor.remove("email");
        editor.remove("token");
        editor.remove("name");
        editor.remove("email_varified_at");
        editor.remove("created_at");
        editor.remove("updated_at");
        editor.remove("status");
        editor.remove("id");
        editor.apply();
        editor.commit();


    }
}
