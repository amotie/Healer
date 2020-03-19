package com.amotie.healar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileReviewAdaptor extends RecyclerView.Adapter<ProfileReviewAdaptor.ViewHolder>{
    private List<ProfileReviewListitem> profileReviewListitems;
    private Context context;
    ProfileReviewAdaptor(List<ProfileReviewListitem> profileReviewListitems,Context context){
        this.profileReviewListitems=profileReviewListitems;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_review_list,parent,false);
        return new ProfileReviewAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProfileReviewListitem profileReviewListitem=profileReviewListitems.get(position);
        holder.ratingBar.setRating(profileReviewListitem.rating);
        holder.profilePicture.setImageBitmap(profileReviewListitem.profilePicture);
        holder.name.setText(profileReviewListitem.name);
        holder.date.setText(profileReviewListitem.date);
        holder.content.setText(profileReviewListitem.content);
    }

    @Override
    public int getItemCount() {
        return profileReviewListitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RatingBar ratingBar;
        CircleImageView profilePicture;
        TextView name;
        TextView date;
        TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ratingBar=(RatingBar) itemView.findViewById(R.id.doctorRating);
            profilePicture=(CircleImageView) itemView.findViewById(R.id.profilePictureReviewer);
            name=(TextView) itemView.findViewById(R.id.nameReviewer);
            date=(TextView)itemView.findViewById(R.id.dateReview);
            content=(TextView)itemView.findViewById(R.id.contentReview);


        }
    }
}
