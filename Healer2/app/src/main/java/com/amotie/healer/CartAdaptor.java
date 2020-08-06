package com.amotie.healer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.ViewHolder> {
    private List<CartLIst> cartLIsts;
    private Context context;
    CartAdaptor(Context context,List<CartLIst> cartLIsts){
        this.cartLIsts=cartLIsts;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_list,parent,false);
        return new CartAdaptor.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        CartLIst cartLIst=cartLIsts.get(position);
        holder.name.setText(cartLIst.name);
        holder.provider.setText(cartLIst.provider);
        holder.imageView.setImageBitmap(cartLIst.image);
        holder.price.setText(cartLIst.price);
        holder.count.setText(cartLIst.count);
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c=Integer.valueOf(holder.count.getText().toString());
                c++;
                String x=String.valueOf(c);
                holder.count.setText(x);
            }
        });
        holder.mines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c=Integer.valueOf(holder.count.getText().toString());
                if (c==1){

                }
                else {
                    c--;
                    String x = String.valueOf(c);
                    holder.count.setText(x);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartLIsts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,provider,count,price;
        ImageButton plus,mines;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.circularImageView);
            name=(TextView) itemView.findViewById(R.id.MedicineNameCart);
            provider=(TextView) itemView.findViewById(R.id.MedicineProviderCart);
            count=(TextView) itemView.findViewById(R.id.CounterCart);
            price=(TextView) itemView.findViewById(R.id.MedicinePriceCart);
            plus=(ImageButton)itemView.findViewById(R.id.plusBtn);
            mines=(ImageButton)itemView.findViewById(R.id.menusBtn);



        }
    }
}
