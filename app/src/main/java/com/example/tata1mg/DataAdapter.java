package com.example.tata1mg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
    public ArrayList<ModelClass>arrayList;

    public DataAdapter(ArrayList<ModelClass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
    ModelClass modelClass=arrayList.get(position);
    holder.setData(modelClass);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
