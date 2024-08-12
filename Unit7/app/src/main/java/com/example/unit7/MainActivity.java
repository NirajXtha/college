package com.example.unit7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an object for MyDbHelper class
        // Create DB, Version, Table
        myDbHelper = new MyDbHelper(this);

        EditText idEt = findViewById(R.id.id);
        EditText nameEt = findViewById(R.id.name);
        EditText addressEt = findViewById(R.id.address);
        TextView resultTv = findViewById(R.id.resultTv);

        Button insert = findViewById(R.id.insert);
        Button select = findViewById(R.id.select);
        Button update = findViewById(R.id.update);
        Button delete = findViewById(R.id.delete);

        // For inserting data into database
        insert.setOnClickListener(v -> {
            int id = Integer.parseInt(idEt.getText().toString());
            String name  = nameEt.getText().toString();
            String address = addressEt.getText().toString();

            try{
                myDbHelper.insertData(id, name, address);

                Toast.makeText(MainActivity.this, "Inserted data successfully!",Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(MainActivity.this, "Something went wrong!!",Toast.LENGTH_LONG).show();

            }
        });

        // For selecting all data from the database
        select.setOnClickListener(v -> {

        });

        // For update the selected data from the database according to the id
        update.setOnClickListener(v -> {

        });

        // For deleting the data set by the user from the database
        delete.setOnClickListener(v -> {

        });
    }
}