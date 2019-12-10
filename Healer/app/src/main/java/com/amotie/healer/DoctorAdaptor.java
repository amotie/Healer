package com.amotie.healer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Observable;

public class DoctorAdaptor extends RecyclerView.Adapter<DoctorAdaptor.ViewHolder>{
     private   List<DoctorListItem> doctorListItems;
     private Context context;


    public DoctorAdaptor(List<DoctorListItem> doctorListItems, Context context) {
        this.doctorListItems = doctorListItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doctorlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        DoctorListItem doctorListItem=doctorListItems.get(position);
        holder.name.setText(doctorListItem.getName());
        holder.location.setText(doctorListItem.getLoction());
        holder.profilePecture=doctorListItem.getProfilePecture();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(),Profile.class);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return doctorListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView location;
        public ImageView profilePecture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.doctorname);
            location=(TextView)itemView.findViewById(R.id.doctorloction);
            profilePecture=(ImageView)itemView.findViewById(R.id.doctorimage);
        }
    }
}
