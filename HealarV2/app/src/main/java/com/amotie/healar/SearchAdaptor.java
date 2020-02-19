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

public class SearchAdaptor extends RecyclerView.Adapter<SearchAdaptor.ViewHolder> {
    private List<SearchListitem> searchListitems;
    private Context context;
    SearchAdaptor(List<SearchListitem> searchListitems,Context context){
        this.searchListitems=searchListitems;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_result_list,parent,false);
        return new SearchAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SearchListitem searchListitem=searchListitems.get(position);
        holder.imageView.setImageBitmap(searchListitem.image);
        holder.name.setText(searchListitem.name);
        holder.specialist.setText(searchListitem.spesialist);
        holder.loction.setText(searchListitem.loction);
        holder.rating.setText(searchListitem.rating);
    }

    @Override
    public int getItemCount() {
        return searchListitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;
        TextView specialist;
        TextView loction;
        TextView rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.DoctorImage);
            name=(TextView) itemView.findViewById(R.id.DoctorName);
            specialist=(TextView)itemView.findViewById(R.id.DoctorSpecilist);
            loction=(TextView)itemView.findViewById(R.id.DoctorLoction);
            rating=(TextView)itemView.findViewById(R.id.doctorRatingtext);


        }
    }
}
