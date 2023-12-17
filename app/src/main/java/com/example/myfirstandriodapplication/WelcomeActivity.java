package com.example.myfirstandriodapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    Button calculatorbtn;
    Button recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        calculatorbtn = findViewById(R.id.calculator_button);
        calculatorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, Calculator.class);
                startActivity(intent);
            }
        });


        recycler= findViewById(R.id.recycler);
        recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this , Recycler.class );
                startActivity(intent);
            }
        });
    }
}
