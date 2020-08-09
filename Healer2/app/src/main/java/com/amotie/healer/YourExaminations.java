package com.amotie.healer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class YourExaminations extends AppCompatActivity {
    RecyclerView recyclerView;
    List<YourExaminationsList> yourExaminationsLists;
    YourExaminationsAdaptor yourExaminationsAdaptor;
    Bitmap lap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_examinations);
        recyclerView = (RecyclerView)findViewById(R.id.yourExaminationRecycleView);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        yourExaminationsLists=new ArrayList<>();
        lap= BitmapFactory.decodeResource(getResources(),R.drawable.elmokhtabar);
        YourExaminationsList yourExaminationsList=new YourExaminationsList(lap,"Pboby CR and Anti-for Covid-19","Booked on: 12:30 AM/Aug. 12 2020","Status:Done","Recived on: 1:00 PM/Aug. 15 2020");
        yourExaminationsLists.add(yourExaminationsList);
         yourExaminationsList=new YourExaminationsList(lap,"Complete Blood Count (CBC)","Booked on: 12:30 AM/Aug. 20 2020","Status:Done","Recived on: 1:00 PM/Aug. 30 2020");
        yourExaminationsLists.add(yourExaminationsList);
        lap= BitmapFactory.decodeResource(getResources(),R.drawable.alfa);
        yourExaminationsList=new YourExaminationsList(lap,"Liver Function","Booked on: 12:30 AM/Aug. 30 2020","Status:Done","Recived on: 1:00 PM/Sep. 4 2020");
        yourExaminationsLists.add(yourExaminationsList);




        yourExaminationsAdaptor=new YourExaminationsAdaptor(yourExaminationsLists,getApplicationContext());
        recyclerView.setAdapter(yourExaminationsAdaptor);

    }
}