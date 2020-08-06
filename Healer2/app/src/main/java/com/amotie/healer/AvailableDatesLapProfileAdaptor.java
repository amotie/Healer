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

public class AvailableDatesLapProfileAdaptor  extends RecyclerView.Adapter<AvailableDatesLapProfileAdaptor.ViewHolder>{
    private List<AvailalbleDatesLapProfileList> availalbleDatesLapProfileLists;
    private Context context;
    int row_index=-1;

    public AvailableDatesLapProfileAdaptor(List<AvailalbleDatesLapProfileList> avaialbleDatesDoctorProfileLists, Context context) {
        this.availalbleDatesLapProfileLists = avaialbleDatesDoctorProfileLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.available_dates_doctorprofile,parent,false);

        return new AvailableDatesLapProfileAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        AvailalbleDatesLapProfileList availalbleDatesLapProfileList=availalbleDatesLapProfileLists.get(position);
        holder.month.setText(availalbleDatesLapProfileList.month);
        holder.day.setText(availalbleDatesLapProfileList.day);
        holder.dateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if (row_index==position){
            holder.dateCard.setCardBackgroundColor(Color.parseColor("#3B75F2"));
            holder.month.setTextColor(Color.parseColor("#F0F2EF"));
            holder.day.setTextColor(Color.parseColor("#F0F2EF"));
            Log.i("Adaptor","yes");
        }
        else {
            holder.dateCard.setCardBackgroundColor(Color.parseColor("#F0F2EF"));
            holder.month.setTextColor(Color.parseColor("#707070"));
            holder.day.setTextColor(Color.parseColor("#707070"));
            Log.i("Adaptor","no");
        }
    }

    @Override
    public int getItemCount() {
        return availalbleDatesLapProfileLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView dateCard;

        TextView month;
        TextView day;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateCard=(CardView)itemView.findViewById(R.id.AvailableDateCardView);
            month=(TextView) itemView.findViewById(R.id.AvailableDateMonth);
            day=(TextView) itemView.findViewById(R.id.AvailableDateDay);



        }
    }
}
