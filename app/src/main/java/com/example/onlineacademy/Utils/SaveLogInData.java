package com.example.onlineacademy.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.onlineacademy.API.Models.user;

public class SaveLogInData {
    public static void saveLogInData(user loginres, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
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
}
