package com.example.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomDialogueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_dialogue);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button customDialog = findViewById(R.id.customDialogBtn);

        customDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(CustomDialogueActivity.this);
            builder.setTitle("Custom Dialog");

            builder.setCancelable(true);

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.custom_dialog, null);
            builder.setView(view);

            EditText firstNum = view.findViewById(R.id.firstEt);
            EditText secondNum = view.findViewById(R.id.secondEt);
            TextView resultTv = view.findViewById(R.id.resultTv);
            Button calculate = view.findViewById(R.id.calculateBtn);

            calculate.setOnClickListener(newView -> {
                double resultSum = Double.parseDouble(firstNum.getText().toString()) + Double.parseDouble(secondNum.getText().toString());
                resultTv.setText("Result: " + resultSum);
            });

            AlertDialog alert = builder.create();
            alert.show();
        });
    }
}