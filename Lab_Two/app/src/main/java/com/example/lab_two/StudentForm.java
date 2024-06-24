package com.example.lab_two;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class StudentForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        Button submitBtn = findViewById(R.id.submitForm);
        EditText stdId = findViewById(R.id.std_id);
        EditText stdName = findViewById(R.id.std_name);
        RadioButton genderMale = findViewById(R.id.male);
        RadioButton genderFemale = findViewById(R.id.female);
        Spinner program = findViewById(R.id.programSpinner);
        TextView result = findViewById(R.id.result);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}