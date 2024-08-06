package com.example.menu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

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

        // ~ Defining the button for context menu ~ (For long press)
        Button contextBtn = findViewById(R.id.contextMenu);
        // ~ registering the button for the context menu ~
        registerForContextMenu(contextBtn);

        // ~ Popup Menu configuration for on click ~
        Button popupBtn = findViewById(R.id.popUpMenu);

        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(
                        MainActivity.this, v
                );
                popupMenu.inflate(R.menu.menu_list);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.item1){
                            Snackbar.make(findViewById(R.id.main), "Selected: Item 1", Snackbar.LENGTH_LONG).show();
                            return true;
                        }else if(item.getItemId() == R.id.item2){
                            Snackbar.make(findViewById(R.id.main), "Selected: Item 2", Snackbar.LENGTH_LONG).show();
                            return true;
                        }else if(item.getItemId() == R.id.item3){
                            Snackbar.make(findViewById(R.id.main), "Selected: Item 3", Snackbar.LENGTH_LONG).show();
                            return true;
                        }else{
                            return false;
                        }
                    }


                });
                popupMenu.show();
            }
        });
        // ~ Popup Menu end ~

        // ~ Alert Dialog ~
        Button dialogBtn = findViewById(R.id.dialogBtn);

        dialogBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Exit App");
            builder.setMessage("Are you sure you want to exit");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Snackbar.make(findViewById(R.id.main), "User Clicked on 'YES'", Snackbar.LENGTH_LONG).show();
                        }
                    }
            );
            builder.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Snackbar.make(findViewById(R.id.main), "User Clicked on 'NO'", Snackbar.LENGTH_LONG).show();
                        }
                    }
            );
            AlertDialog alert = builder.create();
            alert.show();
        });
        // ~ Alert Dialog End ~
    }

    // ~ Option Menu ~
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1){
            Snackbar.make(findViewById(R.id.main), "Selected: " + item.getTitle(), Snackbar.LENGTH_LONG).show();
            return true;
        }else if(item.getItemId() == R.id.item2){
            Snackbar.make(findViewById(R.id.main), "Selected: Item 2", Snackbar.LENGTH_LONG).show();
            return true;
        }else if(item.getItemId() == R.id.item3){
            Snackbar.make(findViewById(R.id.main), "Selected: Item 3", Snackbar.LENGTH_LONG).show();
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
    // ~ Option menu end ~

    // ~ Context Menu ~
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1){
            Snackbar.make(findViewById(R.id.main), "Selected: Item 1", Snackbar.LENGTH_LONG).show();
            return true;
        }else if(item.getItemId() == R.id.item1){
            Snackbar.make(findViewById(R.id.main), "Selected: Item 2", Snackbar.LENGTH_LONG).show();
            return true;
        }else if(item.getItemId() == R.id.item1){
            Snackbar.make(findViewById(R.id.main), "Selected: Item 3", Snackbar.LENGTH_LONG).show();
            return true;
        }else{
            return super.onContextItemSelected(item);
        }
    }
    // ~ Context Menu end ~
}