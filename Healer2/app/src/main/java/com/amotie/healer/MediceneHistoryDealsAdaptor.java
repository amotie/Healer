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

public class MediceneHistoryDealsAdaptor extends RecyclerView.Adapter<MediceneHistoryDealsAdaptor.ViewHolder> {
    private List<MediceneHistoryDealsList> medicineSchauledDealLists;
    private Context context;
    MediceneHistoryDealsAdaptor(List<MediceneHistoryDealsList> medicineSchauledDealLists, Context context){
        this.medicineSchauledDealLists=medicineSchauledDealLists;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medicine_schaduled_deals,parent,false);
        return new MediceneHistoryDealsAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MediceneHistoryDealsList medicineSchauledDealList=medicineSchauledDealLists.get(position);
        holder.image.setImageBitmap(medicineSchauledDealList.image);
        holder.name.setText(medicineSchauledDealList.name);
        holder.provider.setText(medicineSchauledDealList.provider);
        holder.time.setText(medicineSchauledDealList.expectedDelivery);

    }

    @Override
    public int getItemCount() {
        return medicineSchauledDealLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView provider;
        TextView time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.circularImageView);
            name=(TextView) itemView.findViewById(R.id.MedicineName);
            provider=(TextView)itemView.findViewById(R.id.Provider);
            time=(TextView)itemView.findViewById(R.id.Timedate);



        }
    }

}
