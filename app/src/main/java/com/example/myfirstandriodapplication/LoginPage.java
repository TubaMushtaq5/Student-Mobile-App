package com.example.myfirstandriodapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    EditText loginusername;
    EditText loginpassword;
    Button loginButton;
TextView signupp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Initialize your views within the onCreate method.
        loginusername = findViewById(R.id.username);
        loginpassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signupp=findViewById(R.id.signupText);
        signupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = loginusername.getText().toString();
                String password = loginpassword.getText().toString();

                if (authenticateUser(username, password)) {
                    Intent intent = new Intent(LoginPage.this, WelcomeActivity.class);
                    startActivity(intent);
                } else {
                    showToast("Incorrect username or password. Please try again.");
                }
            }
        });
    }

    private boolean authenticateUser(String username, String password) {
        return username.equals("Tuba") && password.equals("123");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
