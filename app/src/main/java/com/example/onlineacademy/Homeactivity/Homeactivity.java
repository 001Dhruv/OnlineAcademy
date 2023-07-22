package com.example.onlineacademy.Homeactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.onlineacademy.Homeactivity.Fragments.profile.Home;
import com.example.onlineacademy.Homeactivity.Fragments.profile.profile;
import com.example.onlineacademy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homeactivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }

    final Fragment home = new Home();
    final Fragment profile = new profile();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, home)
                        .commit();
                return true;

            case R.id.navigation_Profile:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, profile)
                        .commit();
                return true;

        }
            return false;
            }
        }
