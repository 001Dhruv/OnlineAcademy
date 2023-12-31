package com.example.onlineacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import com.example.onlineacademy.Homeactivity.Homeactivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity after the splash duration
                SharedPreferences preferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
                boolean flag=preferences.getBoolean("isLoggedIn",false);
                if(flag){
                    //To HOME Activity
                    Intent intent = new Intent(SplashActivity.this, Homeactivity.class);
                    startActivity(intent);
                }
                else{
                    //To Login Page
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 1500);
    }
}