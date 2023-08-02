package com.example.onlineacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.Models.LoginResponse;
import com.example.onlineacademy.API.Models.user;
import com.example.onlineacademy.Homeactivity.Homeactivity;
import com.example.onlineacademy.Utils.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        UIInit();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBarHandler.showProgressDialog(progressDialog,getString(R.string.creating_your_account));
                validate();
                signup();
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

    private void signup() {
        Instance.getInstance().apiinterface.userRegistration(nameEditText.getText().toString(),emailEditText.getText().toString(),passwordEditText.getText().toString()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {

                    user userData=response.body().getUser();
                    userData.setToken(response.body().getToken());
                    SaveLogInData.saveLogInData(userData,getApplicationContext());
                    ProgressBarHandler.hideProgressDialog(progressDialog);
                    Intent intent = new Intent(getApplicationContext(), Homeactivity.class);
                    startActivity(intent);
                } else {
                    ProgressBarHandler.hideProgressDialog(progressDialog);
                    Toast.makeText(SignupActivity.this, R.string.unable_to_signup, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(SignupActivity.this, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
                Log.e("Api","onfaliure:"+t.getLocalizedMessage());
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
    }
}