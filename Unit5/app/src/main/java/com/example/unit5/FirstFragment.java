package com.example.unit5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        EditText firstNum = view.findViewById(R.id.firstNum);
        EditText secondNum = view.findViewById(R.id.secondNum);
        Button calculate = view.findViewById(R.id.addBtn);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(firstNum.getText().toString());
                double num2 = Double.parseDouble(secondNum.getText().toString());
                double result = num1 + num2;
                Snackbar.make(v,"The final value is: " + result,Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}