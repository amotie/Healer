package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckOut extends AppCompatActivity {
    RecyclerView foryou;
    RecyclerView.Adapter adapter;
    private List<YourItmesList> yourItmesLists;
    TextView subtotal,servicecharge,totalamount,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        getSupportActionBar().hide();
        foryou = (RecyclerView)findViewById(R.id.yourItemChickOut);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        foryou.setHasFixedSize(true);
        foryou.setLayoutManager(layoutManager);
        yourItmesLists=new ArrayList<>();
        subtotal=(TextView)findViewById(R.id.SubTotal);
        servicecharge=(TextView)findViewById(R.id.Serviceharge);
        totalamount=(TextView)findViewById(R.id.TotalAmount);
        total=(TextView)findViewById(R.id.Total);



        YourItmesList yourItmesList=new YourItmesList("Catflam","2x","20LE");
        yourItmesLists.add(yourItmesList);

        yourItmesList=new YourItmesList("Augmantin","4x","50LE");
        yourItmesLists.add(yourItmesList);


        adapter=new YourItemsAdaptor(yourItmesLists,getApplicationContext());
        foryou.setAdapter(adapter);
        total.setText("240LE");
        servicecharge.setText("5LE");
        totalamount.setText("6x");
        subtotal.setText("245LE");


    }


    }
