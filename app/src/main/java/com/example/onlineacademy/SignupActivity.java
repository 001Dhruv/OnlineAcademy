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

import com.example.onlineacademy.Utils.ValidateHandlor;

public class SignupActivity extends AppCompatActivity {
    private CheckBox togglePasswordCheckBox;
    private EditText nameEditText;
    private EditText standardEditText;
    private EditText contactEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText conformPasswordEditText;
    private Button signup;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        UIInit();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        togglePasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                togglePasswordVisibility(isChecked);
            }
        });

    }
    private void UIInit() {
        togglePasswordCheckBox=findViewById(R.id.togglePasswordCheckBoxSignup);
        nameEditText=findViewById(R.id.nameEditTextSignup);
        standardEditText=findViewById(R.id.standardEditTextSignup);
        contactEditText=findViewById(R.id.contactEditTextSignup);
        emailEditText=findViewById(R.id.emailEditTextSignup);
        passwordEditText=findViewById(R.id.passwordEditTextSignup);
        conformPasswordEditText=findViewById(R.id.conformPasswordEditTextSignup);
        signup=findViewById(R.id.signUpButtonSignup);
        login=findViewById(R.id.loginTextViewSignUp);
    }

    private void togglePasswordVisibility(boolean isChecked) {
        if (isChecked) {
            // Show password in plain text
            passwordEditText.setTransformationMethod(null);
            conformPasswordEditText.setTransformationMethod(null);
        } else {
            // Hide password (default behavior)
            conformPasswordEditText.setTransformationMethod(new PasswordTransformationMethod());
        }
    }
    private void validate(){
        if(!ValidateHandlor.isValidEmail(emailEditText.getText().toString())){
            emailEditText.setBackgroundResource(R.drawable.edittext_error);
            emailEditText.setText("");
            emailEditText.setHint(R.string.please_enter_valid_email);
        }
        else if(!ValidateHandlor.isValidContactNumber(contactEditText.getText().toString())){
            contactEditText.setBackgroundResource(R.drawable.edittext_error);
            contactEditText.setText("");
            contactEditText.setHint(R.string.please_enter_valid_contact);
        }
        else if(Integer.parseInt(standardEditText.getText().toString())>12 ||Integer.parseInt(standardEditText.getText().toString())<1){
            standardEditText.setBackgroundResource(R.drawable.edittext_error);
            standardEditText.setText("");
            standardEditText.setHint(R.string.please_enter_valid_standard);
        }
        else if(emailEditText.getText().toString().equals("dhruv@gmail.com")&&passwordEditText.getText().toString().equals("123")){
            saveLoginStatus();
//            Intent int=new Intent(getApplicationContext(),HomeActivity.class);
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