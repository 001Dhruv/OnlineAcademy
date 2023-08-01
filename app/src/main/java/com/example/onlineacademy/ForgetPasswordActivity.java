package com.example.onlineacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPasswordActivity extends AppCompatActivity {
   private EditText email;
   private Button getpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        UIInit();
        getpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPassClick();
            }
        });

    }
    private void getPassClick() {
        sendPasswordOnMail();
        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
    }

    private void UIInit() {
        email=findViewById(R.id.emailEditTextForotPassword);
        getpass=findViewById(R.id.getpasswordButtonForgotPassword);
    }
    void sendPasswordOnMail(){

    }
}