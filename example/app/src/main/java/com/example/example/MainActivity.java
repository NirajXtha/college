package com.example.example;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v->{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Area and Primeter calculator");

            builder.setCancelable(true);

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog, null);
            builder.setView(view);

            EditText firstNum = view.findViewById(R.id.firstNum);
            EditText secondNum = view.findViewById(R.id.secondNum);
            TextView resultTv = view.findViewById(R.id.result);
            Button calculate = view.findViewById(R.id.calculate);

            calculate.setOnClickListener(newView->{
                double area = Double.parseDouble(firstNum.getText().toString()) * Double.parseDouble(secondNum.getText().toString());
                double parameter = 2 * (Double.parseDouble(firstNum.getText().toString()) + Double.parseDouble(secondNum.getText().toString()));

                resultTv.setText("Result\nArea: " + area + "\nParameter: " + parameter);
            });

            AlertDialog alert = builder.create();
            alert.show();
        });
    }
}