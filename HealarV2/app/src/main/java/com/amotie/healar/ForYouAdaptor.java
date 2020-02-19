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

public class ForYouAdaptor extends RecyclerView.Adapter<ForYouAdaptor.ViewHolder> {
    private List<ForYouListItem> forYouListItems;
    private Context context;
    ForYouAdaptor(List<ForYouListItem> forYouListItems,Context context){
        this.forYouListItems=forYouListItems;
        this.context=context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_foryou_fragment_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ForYouListItem forYouListItem=forYouListItems.get(position);
        holder.imageView.setImageBitmap(forYouListItem.image);
        holder.name.setText(forYouListItem.name);
        holder.description.setText(forYouListItem.description);
    }

    @Override
    public int getItemCount() {
        return forYouListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       ImageView imageView;
        TextView name;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.ForyouImage);
            name=(TextView) itemView.findViewById(R.id.ForYouName);
            description=(TextView)itemView.findViewById(R.id.ForYouDescription);


        }
    }
}
