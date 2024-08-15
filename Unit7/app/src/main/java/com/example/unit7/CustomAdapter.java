package com.example.unit7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView id, name, address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_rec);
            name = itemView.findViewById(R.id.name_rec);
            address = itemView.findViewById(R.id.address_rec);
        }
    }
    private ArrayList<UserData> userDataList;
    Activity activity;

    public CustomAdapter(Activity activity, ArrayList<UserData> userDataList) {
        this.activity = activity;
        this.userDataList = userDataList;
    }
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(activity).inflate(R.layout.list_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int p) {
        int position = holder.getAdapterPosition();

        holder.id.setText(userDataList.get(position).getId());
        holder.name.setText("Name: " + userDataList.get(position).getName());
        holder.address.setText("Address: " + userDataList.get(position).getAddress());
    }

    @Override
    public int getItemCount() { return userDataList.size(); }

    public void addItem(UserData newData){
        userDataList.add(newData);
        notifyDataSetChanged();
    }
}
