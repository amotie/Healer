package com.amotie.healer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewDoctorProfileAdaptor extends RecyclerView.Adapter<ReviewDoctorProfileAdaptor.ViewHolder> {
    List<ReviewDoctorProfileList> reviewDoctorProfileLists;
    Context context;

    ReviewDoctorProfileAdaptor(Context context,List<ReviewDoctorProfileList> reviewDoctorProfileLists){
        this.reviewDoctorProfileLists=reviewDoctorProfileLists;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_doctor_profile_list,parent,false);
        return new ReviewDoctorProfileAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    ReviewDoctorProfileList reviewDoctorProfileList=reviewDoctorProfileLists.get(position);
    holder.name.setText(reviewDoctorProfileList.name);
    holder.date.setText(reviewDoctorProfileList.date);
    holder.rate.setRating(reviewDoctorProfileList.rate);
    holder.review.setText(reviewDoctorProfileList.review);
    }

    @Override
    public int getItemCount() {
        return reviewDoctorProfileLists.size();
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
