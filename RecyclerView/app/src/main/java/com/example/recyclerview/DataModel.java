package com.example.recyclerview;

import android.net.Uri;

public class DataModel {
    String name;
    String email;
    int image = 0;
    Uri imageUri;
    public DataModel(String name, String email, int image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public DataModel(String name, String email, Uri imageUri){
        this.name = name;
        this.email = email;
        this.imageUri = imageUri;
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
    public Uri getImageUri(){ return imageUri; }

}
