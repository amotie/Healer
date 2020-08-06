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

public class YourItemsAdaptor extends RecyclerView.Adapter<YourItemsAdaptor.ViewHolder> {
    private List<YourItmesList> yourItmesLists;
    private Context context;
    YourItemsAdaptor(List<YourItmesList> yourItmesLists, Context context){
        this.yourItmesLists=yourItmesLists;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.your_items_chick_out_list,parent,false);
        return new YourItemsAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YourItmesList yourItmesList=yourItmesLists.get(position);
        holder.name.setText(yourItmesList.name);
        holder.count.setText(yourItmesList.count);
        holder.price.setText(yourItmesList.price);
    }

    @Override
    public int getItemCount() {
        return yourItmesLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView count;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=(TextView) itemView.findViewById(R.id.NameItem);
            count=(TextView) itemView.findViewById(R.id.CountItem);
            price=(TextView)itemView.findViewById(R.id.PriceItem);


        }
    }
}
