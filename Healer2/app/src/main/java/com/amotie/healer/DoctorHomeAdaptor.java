package com.amotie.healer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.amotie.healer.DoctorHomeListItem;
import com.amotie.healer.R;

import java.util.List;

public class DoctorHomeAdaptor extends RecyclerView.Adapter<DoctorHomeAdaptor.ViewHolder>{
    private List<DoctorHomeListItem> doctorHomeListItemList;
    private Context context;
     DoctorHomeAdaptor(List<DoctorHomeListItem> doctorHomeListItems, Context context){
        this.doctorHomeListItemList=doctorHomeListItems;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_doctors_fragment_list,parent,false);
        return new DoctorHomeAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorHomeListItem doctorHomeListItem=doctorHomeListItemList.get(position);
        holder.imageView.setImageBitmap(doctorHomeListItem.image);
        holder.name.setText(doctorHomeListItem.name);
        holder.specialist.setText(doctorHomeListItem.spesialist);
        holder.doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),DoctorProfile.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctorHomeListItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView doctor;
        ImageView imageView;
        TextView name;
        TextView specialist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doctor=(CardView)itemView.findViewById(R.id.DoctorHomeCard);
            imageView=(ImageView)itemView.findViewById(R.id.DoctorImage);
            name=(TextView) itemView.findViewById(R.id.DoctorName);
            specialist=(TextView)itemView.findViewById(R.id.DoctorSpecilist);


        }
    }
}