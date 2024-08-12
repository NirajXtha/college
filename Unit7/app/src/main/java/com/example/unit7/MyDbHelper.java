package com.example.unit7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    private  static final int DATABASE_Version = 1;
    private static  final String DATABSE_NAME = "mydb";

    public MyDbHelper(@Nullable Context context){
        super(context,DATABSE_NAME, null, DATABASE_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE myTable(id INTEGER PRIMARY KEY, name TEXT, address TEXT)";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABSE_NAME);
        onCreate(db);
    }

    public void insertData(int id, String name, String address){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("address", address);

        db.insert("myTable", null, contentValues);
        db.close();
    }

    public Cursor selectData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM myTable";
        return db.rawQuery(query, null);
    }

    public void updateData(String id, String name, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);

        db.update("myTable", contentValues, "id=?", new String[]{id});
        db.close();
    }

    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("myTable", "id=?", new String[]{id});
    }
}
