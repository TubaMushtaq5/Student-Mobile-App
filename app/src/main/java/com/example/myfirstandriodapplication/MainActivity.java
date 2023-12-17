package com.example.myfirstandriodapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button welcomee;
    private Button loginn;
    private static final String[] Country_OPTIONS = {"Choose your Country","Pakistan", "UK", "Other", "not preferred to mention"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner cSpinner = findViewById(R.id.countrySpinne);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Country_OPTIONS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cSpinner.setAdapter(adapter);



        EditText username = findViewById(R.id.signup_email);
        EditText password = findViewById(R.id.signup_password);
        EditText confirmPassword = findViewById(R.id.signup_confirm);
        Button regbtn = findViewById(R.id.signup_button);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                String confirmPassword1 = confirmPassword.getText().toString();
                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                if (username1.isEmpty() || password1.isEmpty() || confirmPassword1.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (password1.equals(confirmPassword1)) {
                        Intent intent = new Intent(MainActivity.this, LoginPage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        loginn= findViewById(R.id.login);
        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LoginPage.class );
                startActivity(intent);
            }
        });
    }
}
