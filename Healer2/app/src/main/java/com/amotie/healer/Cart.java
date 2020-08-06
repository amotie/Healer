package com.amotie.healer;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
    RecyclerView foryou;
    RecyclerView.Adapter adapter;
    private List<CartLIst> cartLIsts;
    Bitmap cartImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        foryou = (RecyclerView)findViewById(R.id.CartRecycleView);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        foryou.setHasFixedSize(true);
        foryou.setLayoutManager(layoutManager);
        cartLIsts=new ArrayList<>();
        cartImage= BitmapFactory.decodeResource(getResources(),R.drawable.catflam);

//        if (foryouImage == null){
//            Log.i("Image","Before");
//        }

        CartLIst cartLIst=new CartLIst(cartImage,"Catflam","Elezaby","5","20");
        cartLIsts.add(cartLIst);
        cartImage= BitmapFactory.decodeResource(getResources(),R.drawable.augmantien);
         cartLIst=new CartLIst(cartImage,"Augmantin","Elezaby","20","50");
        cartLIsts.add(cartLIst);


        adapter=new CartAdaptor(getApplicationContext(),cartLIsts);
        foryou.setAdapter(adapter);

    }
    public void CheckOut(View view){
        Intent intent=new Intent(getApplicationContext(),CheckOut.class);
        startActivity(intent);
    }
}