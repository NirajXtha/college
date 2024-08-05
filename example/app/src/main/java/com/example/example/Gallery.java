package com.example.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gallery);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<DataModel> dataModel = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            dataModel.add(new DataModel(
                    "R.drawable.ic_launcher_foreground"
            ));
        }

        View gridView = findViewById(R.id.gridView);

        LayoutInflater inflater = this.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_grid_view, null, true);

        
    }
}