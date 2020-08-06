package com.amotie.healer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewLapProfileAdaptor extends RecyclerView.Adapter<ReviewLapProfileAdaptor.ViewHolder> {
    List<ReviewLapProfileList> reviewLapProfileLists;
    Context context;

    ReviewLapProfileAdaptor(Context context,List<ReviewLapProfileList> reviewLapProfileLists){
        this.reviewLapProfileLists=reviewLapProfileLists;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_doctor_profile_list,parent,false);
        return new ReviewLapProfileAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReviewLapProfileList reviewLapProfileList=reviewLapProfileLists.get(position);
        holder.name.setText(reviewLapProfileList.name);
        holder.date.setText(reviewLapProfileList.date);
        holder.rate.setRating(reviewLapProfileList.rate);
        holder.review.setText(reviewLapProfileList.review);
    }

    @Override
    public int getItemCount() {
        return reviewLapProfileLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView date;
        RatingBar rate;
        TextView review;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.Name);
            date=(TextView) itemView.findViewById(R.id.date);
            rate=(RatingBar)itemView.findViewById(R.id.ratingBar);
            review=(TextView)itemView.findViewById(R.id.review);



        }
    }
}
