package com.example.calclatorsubtask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberEditText, secondNumberEditText;
    private Button addButton, subtractButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = findViewById(R.id.firstNumber);
        secondNumberEditText = findViewById(R.id.secondNumber);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        resultTextView = findViewById(R.id.resultTextView);

        addButton.setOnClickListener(v -> calculateResult('+'));
        subtractButton.setOnClickListener(v -> calculateResult('-'));
    }

    @SuppressLint("SetTextI18n")
    private void calculateResult(char operator) {
        double firstNumber = parseDouble(firstNumberEditText.getText().toString());
        double secondNumber = parseDouble(secondNumberEditText.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
        }

        resultTextView.setText("Result: " + result);
    }

    private double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0; // Return 0 if parsing fails
        }
    }
}
