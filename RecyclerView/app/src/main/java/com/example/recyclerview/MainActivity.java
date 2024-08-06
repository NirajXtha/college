package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);

        Button addBtn = findViewById(R.id.addBtn);
        Button addImage = findViewById(R.id.imageBtn);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<DataModel> dataModels = new ArrayList<>();
        //dataModels.add(new DataModel(name.getText().toString(), "example@abc.com", R.drawable.ic_launcher_foreground));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, dataModels);
        recyclerView.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.AddItem(new DataModel(name.getText().toString(), email.getText().toString(), R.drawable.ic_launcher_foreground));
                name.clearFocus();
                email.clearFocus();
            }
        });
    }
}