package com.example.onlineacademy.Utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.Models.LoginResponse;
import com.example.onlineacademy.API.Models.LogoutResponse;
import com.example.onlineacademy.API.Models.user;
import com.example.onlineacademy.Homeactivity.Homeactivity;
import com.example.onlineacademy.LoginActivity;
import com.example.onlineacademy.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveLogInData {
    static ProgressDialog progressDialog;

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
        editor.putInt("contact",loginres.getContact());
        editor.putInt("standard",loginres.getStandard());
        editor.putInt("id",loginres.getId());
        editor.apply();
    }
    public static void logOutUser(View view) {
        progressDialog = new ProgressDialog(view.getContext());
        ProgressBarHandler.showProgressDialog(progressDialog,view.getContext().getString(R.string.logging_you_out));
        SharedPreferences preferences =view.getContext().getSharedPreferences("loginPrefs",view.getContext().MODE_PRIVATE);
        removeLoginData(preferences);
        logOutUserFromServer(preferences,view);
    }

    private static void removeLoginData(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("isLoggedIn");
        editor.remove("email");
        editor.remove("token");
        editor.remove("name");
        editor.remove("email_varified_at");
        editor.remove("created_at");
        editor.remove("updated_at");
        editor.remove("status");
        editor.remove("id");
        editor.remove("contact");
        editor.remove("standard");
        editor.apply();
        editor.commit();
    }

    private static void logOutUserFromServer(SharedPreferences preferences,View view) {
        Instance.getInstance().apiinterface.userLogout(preferences.getString("token", "")).enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                if (response.isSuccessful()) {
                    ProgressBarHandler.hideProgressDialog(progressDialog);
                    removeLoginData(preferences);
                    Toast.makeText(view.getContext(), R.string.logout_successful, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), LoginActivity.class);
                    view.getContext().startActivity(intent);
                    ((Activity) view.getContext()).finish();


                } else {
                    ProgressBarHandler.hideProgressDialog(progressDialog);
                    Toast.makeText(view.getContext(), R.string.unable_to_log_you_out, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(view.getContext(), R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

