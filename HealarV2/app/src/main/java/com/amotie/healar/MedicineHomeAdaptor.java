package com.amotie.healar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MedicineHomeAdaptor extends RecyclerView.Adapter<MedicineHomeAdaptor.ViewHolder> {
    private List<MedicineHomeListItem> medicineHomeListItems;
    private Context context;
    MedicineHomeAdaptor(List<MedicineHomeListItem> medicineHomeListItems,Context context){
        this.medicineHomeListItems=medicineHomeListItems;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_medicines_fragment_list,parent,false);
        return new MedicineHomeAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicineHomeListItem medicineHomeListItem=medicineHomeListItems.get(position);
        holder.imageView.setImageBitmap(medicineHomeListItem.image);
        holder.name.setText(medicineHomeListItem.name);
        holder.description.setText(medicineHomeListItem.description);

    }

    @Override
    public int getItemCount() {
        return medicineHomeListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.MedicinesImage);
            name=(TextView) itemView.findViewById(R.id.MedicinesName);
            description=(TextView)itemView.findViewById(R.id.MedicinesDescription);


        }
    }
}
