package com.example.androidactivity;

import android.content.Intent;
import android.os.Bundle; //required
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity; //needed

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //exam ma
        setContentView(R.layout.activity_login); //exam ma

        Button homebtn = findViewById(R.id.goHomeBtn);
        Button goBackLogin = findViewById(R.id.goBackLoginBtn);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        goBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        To log the values
//        Log.d("LIFECYCLE_EXAMPLE","ON CREATE CALLED");
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("LIFECYCLE_EXAMPLE","ON START CALLED");
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("LIFECYCLE_EXAMPLE","ON RESUME CALLED");
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("LIFECYCLE_EXAMPLE","ON PAUSE CALLED");
//    }
//
//
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("LIFECYCLE_EXAMPLE","ON STOP CALLED");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("LIFECYCLE_EXAMPLE","ON DESTROY CALLED");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d("LIFECYCLE_EXAMPLE","ON RESTART CALLED");
//    }
    }
}