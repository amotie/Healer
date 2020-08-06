package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MedicineProfile extends AppCompatActivity {
    TextView counter;
    ImageButton plus,subtract;
    RecyclerView review;

    List<ReviewDoctorProfileList> reviewDoctorProfileLists;

    ReviewDoctorProfileAdaptor reviewDoctorProfileAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_profile);
        getSupportActionBar().hide();
        counter=(TextView)findViewById(R.id.CounterCart);
        plus=(ImageButton)findViewById(R.id.plusBtn);
        subtract=(ImageButton)findViewById(R.id.menusBtn);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sub();
            }
        });

        review=(RecyclerView)findViewById(R.id.TypeExaminationReycleView);
        LinearLayoutManager layoutManager2 = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        review.setHasFixedSize(true);
        review.setLayoutManager(layoutManager2);
        reviewDoctorProfileLists=new ArrayList<>();

        ReviewDoctorProfileList reviewDoctorProfileList=new ReviewDoctorProfileList("Ali","15-10-2020",5f,"Exultant");
        reviewDoctorProfileLists.add(reviewDoctorProfileList);
        reviewDoctorProfileList=new ReviewDoctorProfileList("Said","30-10-2020",2.5f,"has bad Side effects");
        reviewDoctorProfileLists.add(reviewDoctorProfileList);
        reviewDoctorProfileList=new ReviewDoctorProfileList("salma","20-6-2020",3.5f,"Nice");
        reviewDoctorProfileLists.add(reviewDoctorProfileList);

        reviewDoctorProfileAdaptor=new ReviewDoctorProfileAdaptor(getApplicationContext(),reviewDoctorProfileLists);
        review.setAdapter(reviewDoctorProfileAdaptor);

    }
    public void addToCart(View view){
        Intent intent=new Intent(getApplicationContext(),Cart.class);
        startActivity(intent);

    }
    public void add(){

        int c=Integer.valueOf(counter.getText().toString());
        c++;
        String x=String.valueOf(c);
        counter.setText(x);
    }
    public void sub(){
        int c=Integer.valueOf(counter.getText().toString());
        if (c==1){

        }
        else {
            c--;
            String x = String.valueOf(c);
            counter.setText(x);
        }
    }
}