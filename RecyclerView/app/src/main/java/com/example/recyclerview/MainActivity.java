package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        Button addBtn = findViewById(R.id.addBtn);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<DataModel> dataModels = new ArrayList<>();
        addBtn.setOnClickListener(v->{
            dataModels.add(new DataModel(name.getText().toString(), email.getText().toString(), R.drawable.ic_launcher_foreground));
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, dataModels);
            recyclerView.setAdapter(adapter);
        });


    }
}