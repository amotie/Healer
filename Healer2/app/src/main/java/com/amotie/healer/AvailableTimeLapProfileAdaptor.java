package com.amotie.healer;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AvailableTimeLapProfileAdaptor extends RecyclerView.Adapter<AvailableTimeLapProfileAdaptor.ViewHolder>  {
    List<String> avaialbleTimeDoctorprofileList;
    Context context;
    int row_index=-1;
    AvailableTimeLapProfileAdaptor(Context context,List<String> avaialbleTimeDoctorprofileList){
        this.avaialbleTimeDoctorprofileList=avaialbleTimeDoctorprofileList;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.available_times_doctorprofile,parent,false);
        return new AvailableTimeLapProfileAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String avaialbleDatesDoctorProfileList=avaialbleTimeDoctorprofileList.get(position);
        holder.time.setText(avaialbleDatesDoctorProfileList);
        holder.timeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if (row_index==position){
            holder.timeCard.setCardBackgroundColor(Color.parseColor("#3B75F2"));
            holder.time.setTextColor(Color.parseColor("#F0F2EF"));
            Log.i("Adaptor","yes");
        }
        else {
            holder.timeCard.setCardBackgroundColor(Color.parseColor("#F0F2EF"));
            holder.time.setTextColor(Color.parseColor("#707070"));
            Log.i("Adaptor","no");
        }
    }

    @Override
    public int getItemCount() {
        return  avaialbleTimeDoctorprofileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView timeCard;


        TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timeCard=(CardView)itemView.findViewById(R.id.AvailableTimeCardView);

            time=(TextView) itemView.findViewById(R.id.AvaiableTimeTextView);



        }
    }
}
