package com.amotie.healer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DoctorHistoryAdaptor extends RecyclerView.Adapter<DoctorHistoryAdaptor.ViewHolder> {

    private List<DoctorHistoryDealsList> doctorHomeListItemList;
    private Context context;
    DoctorHistoryAdaptor(List<DoctorHistoryDealsList> doctorHomeListItems, Context context){
        this.doctorHomeListItemList=doctorHomeListItems;
        this.context=context;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doctor_scheduled_deals_list,parent,false);
        return new DoctorHistoryAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorHistoryDealsList doctorHomeListItem=doctorHomeListItemList.get(position);
        holder.image.setImageBitmap(doctorHomeListItem.image);
        holder.name.setText(doctorHomeListItem.name);
        holder.specialist.setText(doctorHomeListItem.specilest);
        holder.time.setText(doctorHomeListItem.time);
        holder.location.setText(doctorHomeListItem.location);
        holder.price.setText(doctorHomeListItem.price);
    }

    @Override
    public int getItemCount() {
        return doctorHomeListItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView specialist;
        TextView time;
        TextView location;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.circularImageView);
            name=(TextView) itemView.findViewById(R.id.DRName);
            specialist=(TextView)itemView.findViewById(R.id.Specilest);
            time=(TextView)itemView.findViewById(R.id.Timedate);
            location=(TextView)itemView.findViewById(R.id.Location);
            price=(TextView)itemView.findViewById(R.id.Price);


        }
    }
}
