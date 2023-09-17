package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button calculate;
    EditText bmi_ratio,height,weight;
    TextView bmi_cat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = findViewById(R.id.calculateBMI);
        calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        bmi_ratio = findViewById(R.id.BMI);
        height = findViewById(R.id.height_value);
        weight = findViewById(R.id.weight_value);
        bmi_cat = findViewById(R.id.category);
        String category;
        double height_value = Double.parseDouble(height.getText().toString());
        double weight_value = Double.parseDouble(weight.getText().toString());
        double BMI_result =  weight_value/ (height_value* height_value);


        if (BMI_result < 15)
            category = "Very severely underweight";
        else if (BMI_result < 16)
            category = "Severely underweight";
        else if (BMI_result < 18.5)
            category = "Underweight";
        else if (BMI_result < 25)
            category = "Normal";
        else if (BMI_result < 30)
            category = "Overweight";
        else if (BMI_result < 35)
            category = "Obese Class 1 – Moderately Obese";
        else if (BMI_result < 40)
            category = "Obese Class 2 - Severely Obese";
        else
            category = "Obese Class 3 - Very Severely Obese";


        bmi_ratio.setText(String.format("%.2f",BMI_result));
        bmi_cat.setText(category);
    }
}