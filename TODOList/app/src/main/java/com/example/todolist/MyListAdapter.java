package com.example.todolist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] title;
    String[] description;
    String[] date;
    public MyListAdapter(Activity context, String[] title, String[] description, String[] date) {
        super(context, R.layout.custom_text, title);
        this.context = context;
        this.title = title;
        this.description = description;
        this.date = date;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_text, null, true);

        TextView titleTV = rowView.findViewById(R.id.title);
        TextView descriptionTV = rowView.findViewById(R.id.description);
        TextView dateTv = rowView.findViewById(R.id.date);
        titleTV.setText(title[position]);
        descriptionTV.setText(description[position]);
        dateTv.setText(date[position]);

        return rowView;
    }
}
