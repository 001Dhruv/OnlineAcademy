package com.example.onlineacademy.Homeactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.onlineacademy.API.Models.HomeActivityInstance;
import com.example.onlineacademy.Homeactivity.Fragments.profile.Explore;
import com.example.onlineacademy.Homeactivity.Fragments.profile.Home;
import com.example.onlineacademy.Homeactivity.Fragments.profile.Live_Classes;
import com.example.onlineacademy.Homeactivity.Fragments.profile.profile;
import com.example.onlineacademy.Homeactivity.Fragments.profile.video_player_fragment;
import com.example.onlineacademy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Homeactivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        UIInit();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.onlineacademy);
        HomeActivityInstance.setHomeActivity(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);


    }

    private void UIInit() {
        toolbar= findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        bottomNavigationView= findViewById(R.id.bottomNavigationView);
    }




    final Fragment home = new Home();
    final Fragment profile = new profile();
    final Fragment explore= new Explore();
    final Fragment live_class= new Live_Classes();
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                loadFragment(new Home());
                return true;

                case R.id.navigation_explore:
                loadFragment(new Explore());
                return true;
                case R.id.navigation_Live:
                loadFragment(new Live_Classes());
                return true;
                case R.id.navigation_Profile:
                loadFragment(new profile());
                return true;
        }
            return false;
            }

    public void onBackPressed(){
        super.onBackPressed();
        updateBottomNavigationBar();
    }
    public  void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        if(flag) {
            //solves problem of onBackPressed for Fragment
            //Add the fragment to Stack
            flag=false;

            fm.beginTransaction().replace(R.id.flFragment, fragment).commit();
        }
        else{

            fm.beginTransaction().replace(R.id.flFragment, fragment).addToBackStack(null).commit();
        }
        updateBottomNavigationBar();
    }
    private void updateBottomNavigationBar() {
        System.out.println("Update called");
        // Get the BottomNavigationView reference
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // Get the currently selected menu item (fragment)
        int selectedItemId = bottomNavigationView.getSelectedItemId();
        System.out.println("Selected ITEM ID got");
        // Loop through each menu item and set the appropriate icon color
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            MenuItem item = bottomNavigationView.getMenu().getItem(i);
            boolean isSelected = item.getItemId() == selectedItemId;
            System.out.println("Ready to set color");
            item.setIcon(getIconResourceByItemId(item.getItemId()));
            System.out.println("Color set");
        }
    }

    private int getIconResourceByItemId(int itemId) {
        // Implement a method to map the menu item IDs to their respective icons with the given color
        // For example, if you're using a switch-case statement, you can do something like this:
        switch (itemId) {
            case R.id.navigation_home:
                return itemId == getSelectedItemId() ? R.drawable.home_selected: R.drawable.ic_home_black_24dp;
            case R.id.navigation_Live:
                return itemId == getSelectedItemId() ? R.drawable.signal_stream_selected : R.drawable.signal_stream;
            case R.id.navigation_explore:
                return itemId == getSelectedItemId() ? R.drawable.explore_selected : R.drawable.explore;
            case R.id.navigation_Profile:
                return itemId == getSelectedItemId() ? R.drawable.profile_icon_selected : R.drawable.profile_icon;
            default:
                return R.drawable.baseline_person_24;
        }
    }
    private int getSelectedItemId() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        return bottomNavigationView.getSelectedItemId();
    }



}
