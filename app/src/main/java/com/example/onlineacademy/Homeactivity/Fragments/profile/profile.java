package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.onlineacademy.LoginActivity;
import com.example.onlineacademy.R;
import com.example.onlineacademy.SignupActivity;

import org.w3c.dom.Text;


public class profile extends Fragment {

    private TextView logout ;
    private Button edit ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        logout = view.findViewById(R.id.logout); // Replace 'R.id.logoutTextView' with the actual ID of your logout TextView.
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to navigate to the LoginPageActivity
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        edit = view.findViewById(R.id.editprofile) ;
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SignupActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

}