package com.example.myapp2forws2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextResult;
    private Spinner spinnerOperations;
    private Button buttonCalculate, buttonClearFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextResult = findViewById(R.id.editTextResult);
        spinnerOperations = findViewById(R.id.spinnerOperations);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonClearFields = findViewById(R.id.buttonClearFields);

        buttonCalculate.setOnClickListener(buttonCalculateClickListener);
        buttonClearFields.setOnClickListener(buttonClearFieldsClickListener);

    }

    View.OnClickListener buttonCalculateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());

            int operation = spinnerOperations.getSelectedItemPosition();

            double result = 0;

            switch (operation) {
                case 0:
                    result = a + b;
                    break;
                case 1:
                    result = a - b;
                    break;
                case 2:
                    result = a * b;
                    break;
                case 3:
                    result = a / b;
                    break;
            }

            editTextResult.setText(Double.toString(result));
        }
    };

    View.OnClickListener buttonClearFieldsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editTextA.setText("");
            editTextB.setText("");
            editTextResult.setText("");
        }
    };
}