package com.example.todolist;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_example);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.listView);

        String title[] = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        String desc[] = {"This is description 1", "This is description 2", "This is description 3", "This is description 4", "This is description 5"};
        String date[] = {"2024/07/01", "2024/07/02", "2024/07/03", "2024/07/04", "2024/07/05"};

        MyListAdapter myListAdapter = new MyListAdapter(this, title, desc, date);

        listView.setAdapter(myListAdapter);
    }
}