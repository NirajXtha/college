package com.example.unit7;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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

        Button insert = findViewById(R.id.insert);
        Button select = findViewById(R.id.select);
        Button update = findViewById(R.id.update);
        Button delete = findViewById(R.id.delete);

        // ~ Setting up recycler view ~
        RecyclerView recyclerView = findViewById(R.id.recycleView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // For inserting data into database
        insert.setOnClickListener(v -> {
            int id = Integer.parseInt(idEt.getText().toString());
            String name  = nameEt.getText().toString();
            String address = addressEt.getText().toString();

            try{
                myDbHelper.insertData(id, name, address);

                Toast.makeText(MainActivity.this, "Inserted data successfully!",Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(MainActivity.this, e.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        // For selecting all data from the database
//        select.setOnClickListener(v -> {
//            // ~ For normal select ~
//            ArrayList<Integer> ids = new ArrayList<Integer>();
//            ArrayList<String> names = new ArrayList<String>(),
//                address = new ArrayList<String>();
//
//            Cursor cursor = myDbHelper.selectData();
//            while(cursor.moveToNext()){
//                ids.add(cursor.getInt(0));
//                names.add(cursor.getString(1));
//                address.add(cursor.getString(2));
//            }
//
//            String data = "";
//
//            for (int i = 0; i < ids.size(); i++) {
//                data += "ID = " + ids.get(i) + "\nName = " + names.get(i) + "\nAddress = " + address.get(i) + "\n\n";
//            }
//            resultTv.setText(data);
//            // ~ Normal select end~
//        });

        // For selecting all data from the database in a recycler view
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ~ Recycler View selecting data ~
                try {
                    ArrayList<UserData> data = new ArrayList<>();

                    Cursor cursor = myDbHelper.selectData();
                    while (cursor.moveToNext()) {
                        UserData userData = new UserData(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2)
                        );
                        data.add(userData);
                    }
                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, data);
                    recyclerView.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        // For update the selected data from the database according to the id
        update.setOnClickListener(v -> {
            String id = idEt.getText().toString();
            String name  = nameEt.getText().toString();
            String address = addressEt.getText().toString();

            try{
                myDbHelper.updateData(id, name, address);
                Toast.makeText(MainActivity.this, "Updated data successfully",Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(MainActivity.this, "Something went wrong!!",Toast.LENGTH_LONG).show();

            }
        });

        // For deleting the data set by the user from the database
        delete.setOnClickListener(v -> {
            String id = idEt.getText().toString();
            try{
                myDbHelper.deleteData(id);
                Toast.makeText(MainActivity.this, "Deleted data successfully",Toast.LENGTH_LONG).show();
            }catch(Exception e){
                Toast.makeText(MainActivity.this, "Something went wrong!!",Toast.LENGTH_LONG).show();
            }
        });
    }
}