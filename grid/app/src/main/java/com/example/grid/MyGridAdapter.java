package com.example.grid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyGridAdapter extends ArrayAdapter<com.example.grid.MyDataModel> {
    private final Activity context;
    private final ArrayList<com.example.grid.MyDataModel> dataModels;

    public MyGridAdapter(Activity context, ArrayList<com.example.grid.MyDataModel> dataModels) {
        super(context, R.layout.custom_list, dataModels);
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list, null, true);

        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView titleTextView = rowView.findViewById(R.id.title);
        TextView descTextView = rowView.findViewById(R.id.description);
        TextView dateTextView = rowView.findViewById(R.id.date);

        com.example.grid.MyDataModel dataModel = dataModels.get(position);

        // Update the views with the data
        imageView.setImageResource(R.mipmap.ic_launcher_round); // Update with your own image
        titleTextView.setText(dataModel.getTitle());
        descTextView.setText(dataModel.getDescription());
        dateTextView.setText(dataModel.getDate());

        return rowView;
    }
}
