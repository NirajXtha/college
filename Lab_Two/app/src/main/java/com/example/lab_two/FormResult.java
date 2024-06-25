package com.example.lab_two;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FormResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_result);
        TextView result = findViewById(R.id.result);

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        String name = i.getStringExtra("name");
        String gender = i.getStringExtra("gender");
        String academics = i.getStringExtra("program");

        String resultSet = "\nStudent Id:\t" + id +
                "\nStudent Name:\t" + name +
                "\nGender:\t" + gender +
                "\nProgram:\t" + academics;
        result.setText(resultSet);
    }
}