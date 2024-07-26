package com.example.recyclerview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataModel {
    String name;
    String email;
    int image;
    public DataModel(String name, String email, int image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public int getImage(){
        return image;
    }

}
