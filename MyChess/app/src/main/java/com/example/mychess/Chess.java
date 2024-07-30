package com.example.mychess;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chess extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    private static int MAX_LENGTH_WIDTH = 8;

    public static final String PIECE_BR = "bR";
    public static final String PIECE_BN = "bN";
    public static final String PIECE_BB = "bB";
    public static final String PIECE_BQ = "bQ";
    public static final String PIECE_BK = "bK";
    public static final String PIECE_BP = "bP";
    public static final String PIECE_WR = "wR";
    public static final String PIECE_WN = "wN";
    public static final String PIECE_WB = "wB";
    public static final String PIECE_WQ = "wQ";
    public static final String PIECE_WK = "wK";
    public static final String PIECE_WP = "wP";
    public static final String PIECE_NO = "--";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chess);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onClick(View v) {

    }
}