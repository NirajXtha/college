package com.example.recyclerview;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv, emailTv;
        ImageView imageView;
        Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            emailTv = itemView.findViewById(R.id.emailTv);
            imageView = itemView.findViewById(R.id.imageView);
            btn = itemView.findViewById(R.id.btn);
        }
    }

    Activity activity;
//    String[]  names;
//    String[] emails;
//    int[] images;
private List<Uri> mediaList;
    ArrayList<DataModel> dataModels;

    public MyRecyclerViewAdapter(Activity activity, ArrayList<DataModel> dataModels){
        this.activity = activity;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        View listItem = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int p) {
        int position = holder.getAdapterPosition();

        holder.nameTv.setText(dataModels.get(position).getName());
        holder.emailTv.setText(dataModels.get(position).getEmail());
        if(dataModels.get(position).getImage() == 0){
            holder.imageView.setImageURI(dataModels.get(position).getImageUri());
        }else{
            holder.imageView.setImageResource(dataModels.get(position).getImage());
        }


//        holder.nameTv.setText(names[position]);
//        holder.emailTv.setText(emails[position]);
//        holder.imageView.setImageResource(images[position]);
//
        holder.btn.setOnClickListener(v ->{
            Snackbar.make(v, "The name is: " + dataModels.get(position).getName() + "\nThe email is: " + dataModels.get(position).getEmail(), Snackbar.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public void AddItem(DataModel newData){
        dataModels.add(newData);
        notifyDataSetChanged();
    }
}
