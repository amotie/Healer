package com.amotie.healer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LapsHealAdaptor  extends RecyclerView.Adapter<LapsHealAdaptor.ViewHolder> {
    private List<LapsHealList> lapsHealLists;
    private Context context;
        LapsHealAdaptor(List<LapsHealList> lapsHealLists,Context context){
            this.lapsHealLists=lapsHealLists;
            this.context=context;
        }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.laps_list_heal,parent,false);
        return new LapsHealAdaptor.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LapsHealList lapsHealList=lapsHealLists.get(position);
        holder.imageView.setImageBitmap(lapsHealList.image);
    }

    @Override
    public int getItemCount() {
        return lapsHealLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.LapsHealImageView);



        }
    }
}
