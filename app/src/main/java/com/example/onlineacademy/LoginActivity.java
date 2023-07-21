package com.example.onlineacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private CheckBox togglePasswordCheckBox;
    private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        togglePasswordCheckBox = findViewById(R.id.togglePasswordCheckBox);
        passwordEditText = findViewById(R.id.passwordEditText);

        togglePasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                togglePasswordVisibility(isChecked);
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
}