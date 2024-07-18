package com.example.grid;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.grid.MyDataModel;
import com.example.grid.MyGridAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int count = 20;

        ArrayList<MyDataModel> myDataModels = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            myDataModels.add(new MyDataModel(
                    "Item" + i,
                    "This is description " + i,
                    "2024-07-" + (i < 10 ? "0" + i : i)
            ));
        }

        // Find GridView
        GridView gridView = findViewById(R.id.gridView);

        // Create and set adapter
        MyGridAdapter adapter = new MyGridAdapter(this, myDataModels);
        gridView.setAdapter(adapter);

        // Set item click listener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyDataModel myDataModel = myDataModels.get(position);
                String title = myDataModel.getTitle();
                String description = myDataModel.getDescription();
                String date = myDataModel.getDate();

                Snackbar.make(view, "Clicked " + title + ": " + description + " on " + date, Snackbar.LENGTH_LONG).show();
            }
        });
    }
}