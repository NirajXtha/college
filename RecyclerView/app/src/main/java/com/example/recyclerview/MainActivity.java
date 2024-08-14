package com.example.recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGES_REQUEST = 1;
    private ArrayList<DataModel> dataModels = new ArrayList<>();
    private MyRecyclerViewAdapter adapter;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);

        Button addBtn = findViewById(R.id.addBtn);
        Button addImage = findViewById(R.id.imageBtn);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        //dataModels.add(new DataModel(name.getText().toString(), "example@abc.com", R.drawable.ic_launcher_foreground));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyRecyclerViewAdapter(this, dataModels);
        recyclerView.setAdapter(adapter);

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
                startActivityForResult(intent, PICK_IMAGES_REQUEST);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageUri == null){
                    adapter.AddItem(new DataModel(name.getText().toString(), email.getText().toString(), R.drawable.ic_launcher_foreground));
                }else{
                    adapter.AddItem(new DataModel(name.getText().toString(), email.getText().toString(), imageUri));
                }
                name.clearFocus();
                email.clearFocus();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGES_REQUEST && resultCode == RESULT_OK && data != null) {
            if (data.getClipData() != null) {
                int count = data.getClipData().getItemCount();
                for (int i = 0; i < count; i++) {
                    imageUri = data.getClipData().getItemAt(i).getUri();
                }
            } else if (data.getData() != null) {
                imageUri = data.getData();
            }
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "No media selected", Toast.LENGTH_SHORT).show();
        }
    }
}