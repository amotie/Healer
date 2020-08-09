package com.amotie.healer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class YourExaminationsAdaptor extends RecyclerView.Adapter<YourExaminationsAdaptor.ViewHolder> {
    List<YourExaminationsList> yourExaminationsLists;
    Context context;

    public YourExaminationsAdaptor(List<YourExaminationsList> yourExaminationsLists, Context context) {
        this.yourExaminationsLists = yourExaminationsLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.your_examination_list,parent,false);

        return new YourExaminationsAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YourExaminationsList yourExaminationsList=yourExaminationsLists.get(position);
        holder.imageView.setImageBitmap(yourExaminationsList.bitmap);
        holder.name.setText(yourExaminationsList.name);
        holder.bookedon.setText(yourExaminationsList.bookedDate);
        holder.status.setText(yourExaminationsList.status);
        holder.recived.setText(yourExaminationsList.recived);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("asddddd","asdasdasdasd");
                Intent intent = new Intent(v.getContext(), ExaminationItemDetales.class);
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return yourExaminationsLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        CircularImageView imageView;
        TextView name;
        TextView bookedon;
        TextView status;
        TextView recived;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.cardView);
            imageView=(CircularImageView)itemView.findViewById(R.id.circularImageView);;
            name=(TextView) itemView.findViewById(R.id.ExaminationName);
            bookedon=(TextView) itemView.findViewById(R.id.BookedDate);
            status=(TextView) itemView.findViewById(R.id.status);
            recived=(TextView)itemView.findViewById(R.id.Received);



        }
    }
}
