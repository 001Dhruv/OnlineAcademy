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

import com.example.onlineacademy.API.API;
import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.Models.LoginResponse;
import com.example.onlineacademy.API.Models.user;
import com.example.onlineacademy.Homeactivity.Homeactivity;
import com.example.onlineacademy.Utils.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private CheckBox togglePasswordCheckBox;
    private EditText passwordEditText;
    private EditText emailEditText;
    private TextView signup;
    private Button login;
    private TextView fogotpass;
    private API apiinterface;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       UIInit();
        togglePasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                togglePasswordVisibility(isChecked);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(LoginActivity.this);
                ProgressBarHandler.showProgressDialog(progressDialog,getString(R.string.logging_you_in));
                validate();
                Log.e("login","validation complete");
                signIn();

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });
        fogotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgetpass();

            }
        });
    }

    private void forgetpass() {
        Intent intent = new Intent(getApplicationContext(), ForgetPasswordActivity.class);
        startActivity(intent);
    }

    private void signIn() {
        Instance.getInstance().apiinterface.userLogin(emailEditText.getText().toString(),passwordEditText.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.e("login","response got");

                    String responseBody = null;
                    try {
                        responseBody = response.body().string();
                        Log.e("login","converted to string");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (responseBody != null) {
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody);

                            if (jsonObject.has("user") && jsonObject.has("token")) {
                                JSONObject userdata=jsonObject.getJSONObject("user");
                                if(userdata.has("standard")){
                                    Log.e("login","json object have staandard");
                                }

                                user userDetails=new user(userdata.getInt("id"),userdata.getString("name"),userdata.getString("email"),"", userdata.getString("created_at"), userdata.getString("updated_at"), userdata.getString("status"), jsonObject.getString("token"),userdata.getInt("standard"),userdata.getInt("contact"));
                                LoginResponse loginRes=new LoginResponse(userDetails,jsonObject.getString("token"));
                                Log.e("login","data set in object");

                                SaveLogInData.saveLogInData(userDetails,getApplicationContext());
                                ProgressBarHandler.hideProgressDialog(progressDialog);
                                Intent intent = new Intent(getApplicationContext(), Homeactivity.class);
                                startActivity(intent);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // The response is not a valid JSON, check if it contains the error message
                        if (responseBody.equals("Email Or Password Not Matches")) {
                            ProgressBarHandler.hideProgressDialog(progressDialog);
                            Toast.makeText(LoginActivity.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Log.e("login","response  not got");

                    ProgressBarHandler.hideProgressDialog(progressDialog);

                    Toast.makeText(LoginActivity.this, R.string.unable_to_log_you_in, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("login","faliuer in getting data");

                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(LoginActivity.this, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
                Log.e("Api","onfaliure:"+t.getLocalizedMessage());
            }
        });

    }


    private void UIInit() {
        togglePasswordCheckBox = findViewById(R.id.togglePasswordCheckBoxLogin);
        passwordEditText = findViewById(R.id.passwordEditTextLogin);
        emailEditText=findViewById(R.id.emailEditTextLogin);
        login=findViewById(R.id.loginButtonLogin);
        signup=findViewById(R.id.signupTextViewLogin);
        fogotpass=findViewById(R.id.forgotPasswordTextViewLogin);
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
        if(!ValidateHandlor.isValidEmail(emailEditText.getText().toString().trim())){
            emailEditText.setBackgroundResource(R.drawable.edittext_error);
            emailEditText.setText("");
            emailEditText.setHint(R.string.please_enter_valid_email);
            ProgressBarHandler.hideProgressDialog(progressDialog);
        }
    }

}