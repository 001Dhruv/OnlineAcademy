package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.Models.HomeActivityInstance;
import com.example.onlineacademy.API.Models.LogoutResponse;
import com.example.onlineacademy.Homeactivity.Homeactivity;
import com.example.onlineacademy.LoginActivity;
import com.example.onlineacademy.R;
import com.example.onlineacademy.Utils.ProgressBarHandler;
import com.example.onlineacademy.Utils.SaveLogInData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment_edit_profile extends Fragment {
    private EditText name;
    private EditText contact;
    private EditText email;
    private EditText standard;
    private Button apply_changes;
    ProgressDialog progressDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edit_profile, container, false);
        SharedPreferences preferences=view.getContext().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        UIInit(view);
        setCurrentValuesFromSharedprefernces(view,preferences);
        apply_changes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(view.getContext());
                ProgressBarHandler.showProgressDialog(progressDialog,getString(R.string.applying_changes));
                applyChanges(view,preferences);
            }
        });
        return view;
    }

    private void applyChanges(View view, SharedPreferences preferences) {
        Instance.getInstance().apiinterface.userLogout(preferences.getString("token", "")).enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                if (response.isSuccessful()) {
                    ProgressBarHandler.hideProgressDialog(progressDialog);
//                    SaveLogInData.saveLogInData();
                    Toast.makeText(view.getContext(), R.string.changes_applied_successfully, Toast.LENGTH_SHORT).show();
                    loadFragment(new fragment_edit_profile());
                    ((Activity) view.getContext()).finish();
                } else {
                    ProgressBarHandler.hideProgressDialog(progressDialog);
                    Toast.makeText(view.getContext(), R.string.error_updating_data, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(view.getContext(), R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Fragment fragment ) {
        Homeactivity homeActivity = HomeActivityInstance.getHomeActivity();
        homeActivity.loadFragment(new profile());
    }

    private void setCurrentValuesFromSharedprefernces(View view,SharedPreferences preferences) {
        name.setText(preferences.getString("name",""));
        email.setText(preferences.getString("email",""));
        contact.setText(preferences.getString("contact",""));
        standard.setText(preferences.getString("standard",""));
    }

    private void UIInit(View view) {
        name=view.findViewById(R.id.edit_profile_name);
        email=view.findViewById(R.id.edit_profile_email);
        contact=view.findViewById(R.id.edit_profile_contact);
        standard=view.findViewById(R.id.edit_profile_standard);
        apply_changes=view.findViewById(R.id.edit_profile_btn);
    }
}