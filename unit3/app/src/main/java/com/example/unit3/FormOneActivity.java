package com.example.unit3;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import  android.widget.EditText;
import android.widget.RadioButton;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class FormOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.form_one);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText nameEt = findViewById(R.id.nameEt);
        RadioButton maleRb = findViewById(R.id.radioBtnMale);
        RadioButton femaleRb = findViewById(R.id.radioBtnFemale);
        EditText phoneEt = findViewById(R.id.phoneEt);
        CheckBox agreeCb = findViewById(R.id.consentCheckbox);
        Button submitBtn = findViewById(R.id.SubmitBtn);
        TextView result = findViewById(R.id.result);

        Spinner academics = findViewById(R.id.spinners);

        submitBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (agreeCb.isChecked()) {
                    String enteredName = nameEt.getText().toString();
                    String selectedGender = "Unknown Gender, maybe even gay";
                    if(maleRb.isChecked()){
                        selectedGender = "Male";
                    }if(femaleRb.isChecked()){
                        selectedGender = "Female";
                    }
                    String enteredPhone = phoneEt.getText().toString();
                    String selectedAcademics = academics.getSelectedItem().toString();
                    String endResult = "Result:";
                    endResult += "\nName: " + enteredName;
                    endResult += "\nGender: " + selectedGender;
                    endResult += "\nAcademics: " + selectedAcademics;
                    endResult +="\nPhone Number: " + enteredPhone;

                    result.setText(endResult);
                    // Perform the action with the enteredName if required
                    Snackbar.make(v, "Form submitted successfully", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(v, "Please agree to the terms and conditions", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
