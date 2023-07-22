package com.example.onlineacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.validation.Validator;


public class LoginActivity extends AppCompatActivity {
    private CheckBox togglePasswordCheckBox;
    private EditText passwordEditText;
    private EditText emailEditText;
    private TextView signup;
    private Button login;
    private TextView fogotpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        togglePasswordCheckBox = findViewById(R.id.togglePasswordCheckBoxLogin);
        passwordEditText = findViewById(R.id.passwordEditTextLogin);
        emailEditText=findViewById(R.id.emailEditTextLogin);
        login=findViewById(R.id.loginButtonLogin);
        signup=findViewById(R.id.signupTextViewLogin);
        fogotpass=findViewById(R.id.forgotPasswordTextViewLogin);

        togglePasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                togglePasswordVisibility(isChecked);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
        fogotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void togglePasswordVisibility(boolean isChecked) {
        if (isChecked) {
            // Show password in plain text
            passwordEditText.setTransformationMethod(null);
        } else {
            // Hide password (default behavior)
            passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
        }
    }
    private void validate(){
        if(!ValidateHandlor.isValidEmail(emailEditText.getText().toString())){
            emailEditText.setBackgroundResource(R.drawable.edittext_error);
            emailEditText.setText("");
            emailEditText.setHint(R.string.please_enter_valid_email);
        }
        else if(emailEditText.getText().toString().equals("dhruv@gmail.com")&&passwordEditText.getText().toString().equals("123")){
            saveLoginStatus();
//            Intent int=new Intent(LoginActivity.this,HomeActivity.class);
//              startActivity(int);
            finish();
        }
    }
    private void saveLoginStatus() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.putString("email",emailEditText.getText().toString());
        editor.putString("name","Dhruv patel");//need to get name from database
        editor.apply();
    }
}