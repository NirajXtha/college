package com.example.androidactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button goBackLogin = findViewById(R.id.goBackBtn);

        TextView contentTv = findViewById(R.id.contentTv);
        Button showBtn = findViewById(R.id.showBtn);

        Intent i = getIntent();
        int id = i.getIntExtra("id", 0);
        String name = i.getStringExtra("name");
        int age = i.getIntExtra("age", 0);
        String address = i.getStringExtra("address");

        String result = "\nId: " + id +
                "\nName: " + name +
                "\nAge: " + age +
                "\nAddress: " + address;

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentTv.setText(result);
            }
        });
    }
}