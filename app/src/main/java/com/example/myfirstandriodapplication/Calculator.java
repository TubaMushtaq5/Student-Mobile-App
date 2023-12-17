package com.example.myfirstandriodapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator extends AppCompatActivity {
    private EditText inputField;
    private Button button7, button8, button9, buttonDivide, button4, button5, button6, buttonMultiply, button1, button2, button3, buttonSubtract, button0, buttonDecimal, buttonEquals, buttonAdd, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        inputField = findViewById(R.id.inputField);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDivide = findViewById(R.id.buttonDivide);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        button0 = findViewById(R.id.button0);
        buttonDecimal = findViewById(R.id.buttonDecimal);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {appendToInputField("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("9");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("/");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("6");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("*");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("3");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("-");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("0");
            }
        });

        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField(".");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the equals button click (perform calculation)
                calculateResult();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToInputField("+");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputField();
            }
        });
    }

    // Helper method to append text to the input field
    private void appendToInputField(String text) {
        String currentText = inputField.getText().toString();
        currentText += text;
        inputField.setText(currentText);
    }

    // Helper method to clear the input field
    private void clearInputField() {
        inputField.setText("");
    }

    // Helper method to calculate the result
    private void calculateResult() {
        String inputText = inputField.getText().toString();
        try {
            Expression expression = new ExpressionBuilder(inputText).build();
            double result = expression.evaluate();
            inputField.setText(String.valueOf(result));
        } catch (ArithmeticException | IllegalArgumentException e) {
            inputField.setText("Error");
        }
    }

}
