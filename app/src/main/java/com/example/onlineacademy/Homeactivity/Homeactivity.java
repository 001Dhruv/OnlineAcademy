package com.example.onlineacademy.Homeactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.onlineacademy.Homeactivity.Fragments.profile.Explore;
import com.example.onlineacademy.Homeactivity.Fragments.profile.Home;
import com.example.onlineacademy.Homeactivity.Fragments.profile.Live_Classes;
import com.example.onlineacademy.Homeactivity.Fragments.profile.profile;
import com.example.onlineacademy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Homeactivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.onlineacademy);



        bottomNavigationView= findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    final Fragment home = new Home();
    final Fragment profile = new profile();
    final Fragment explore= new Explore();
    final Fragment live_class= new Live_Classes();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, home)
                        .commit();
                return true;

                case R.id.navigation_explore:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, explore)
                        .commit();
                return true;
            case R.id.navigation_Live:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, live_class)
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
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }

    }
}
