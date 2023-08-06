package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineacademy.Homeactivity.Homeactivity;
import com.example.onlineacademy.LoginActivity;
import com.example.onlineacademy.R;
import com.example.onlineacademy.SignupActivity;
import com.example.onlineacademy.Utils.SaveLogInData;
import com.example.onlineacademy.API.Models.*;

import org.w3c.dom.Text;


public class profile extends Fragment {


    private Button edit ;
    private TextView profile_name;
    private TextView profile_email;
    private TextView profile_contact;
    private TextView profile_standard;
    private ImageView profile_logout_btn;
    private TextView logout_text ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        UIInit(view);
        setContentOfViewElements(view);
        logout_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOutUser(view);
            }
        });
        profile_logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOutUser(view);
            }
        });

        edit = view.findViewById(R.id.editprofile) ;
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Homeactivity homeActivity = HomeActivityInstance.getHomeActivity();
                homeActivity.loadFragment(new fragment_edit_profile());
            }
        });

        return view;
    }

    private void logOutUser(View view) {
        SaveLogInData.logOutUser(view);
        Intent intent = new Intent(view.getContext(), LoginActivity.class);
        getActivity().startActivity(intent);
        getActivity().finish();
    }

    private void setContentOfViewElements(View view) {
        SharedPreferences preferences =view.getContext().getSharedPreferences("loginPrefs",view.getContext().MODE_PRIVATE);
        profile_name.setText(preferences.getString("name",""));
        profile_email.setText(preferences.getString("email",""));
    }

    private void UIInit(View view) {
        logout_text = view.findViewById(R.id.profile_logout);
        profile_logout_btn=view.findViewById(R.id.profile_logout_btn);
        profile_name=view.findViewById(R.id.profile_name);
        profile_email=view.findViewById(R.id.profile_email);
        profile_contact=view.findViewById(R.id.profile_contact);
        profile_logout_btn=view.findViewById(R.id.profile_logout_btn);
    }

}