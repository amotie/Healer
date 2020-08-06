package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DoctorProfile extends AppCompatActivity {
    RecyclerView availabledate,availabletime,review;
    List<AvaialbleDatesDoctorProfileList> avaialbleDatesDoctorProfileLists;
    List<String> availavleTimesDoctorProfileList;
    List<ReviewDoctorProfileList> reviewDoctorProfileLists;
    AvailableTimeDoctorprofileAdaptor availableTimeDoctorprofileAdaptor;
    AvailableDatesDoctorprofileAdaptor availableDatesDoctorprofileAdaptor;
    ReviewDoctorProfileAdaptor reviewDoctorProfileAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_doctor_profile);
        availabledate=(RecyclerView)findViewById(R.id.AvailableDateRecycleView);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        availabledate.setHasFixedSize(true);
        availabledate.setLayoutManager(layoutManager);
        avaialbleDatesDoctorProfileLists=new ArrayList<>();

            AvaialbleDatesDoctorProfileList avaialbleDatesDoctorProfileList=new AvaialbleDatesDoctorProfileList("MON","28");

            avaialbleDatesDoctorProfileLists.add(avaialbleDatesDoctorProfileList);
         avaialbleDatesDoctorProfileList=new AvaialbleDatesDoctorProfileList("TOU","29");

        avaialbleDatesDoctorProfileLists.add(avaialbleDatesDoctorProfileList);
         avaialbleDatesDoctorProfileList=new AvaialbleDatesDoctorProfileList("WEN","30");

        avaialbleDatesDoctorProfileLists.add(avaialbleDatesDoctorProfileList);
        avaialbleDatesDoctorProfileList=new AvaialbleDatesDoctorProfileList("THE","31");

        avaialbleDatesDoctorProfileLists.add(avaialbleDatesDoctorProfileList);

        availableDatesDoctorprofileAdaptor=new AvailableDatesDoctorprofileAdaptor(getApplicationContext(),avaialbleDatesDoctorProfileLists);
        availabledate.setAdapter(availableDatesDoctorprofileAdaptor);
//----------------------------------------------------DoctorProfileTime-----------------------------------------------
    availabletime=(RecyclerView)findViewById(R.id.AvailableTimesRecycleView);
        LinearLayoutManager layoutManager1 = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        availabletime.setHasFixedSize(true);
        availabletime.setLayoutManager(layoutManager1);
        availavleTimesDoctorProfileList=new ArrayList<>();


            availavleTimesDoctorProfileList.add("9:00 AM");
        availavleTimesDoctorProfileList.add("12:00 PM");
        availavleTimesDoctorProfileList.add("3:00 PM");


        availableTimeDoctorprofileAdaptor=new AvailableTimeDoctorprofileAdaptor(getApplicationContext(),availavleTimesDoctorProfileList);
        availabletime.setAdapter(availableTimeDoctorprofileAdaptor);
//---------------------------------------------------Review-----------------------------------------------------------
        review=(RecyclerView)findViewById(R.id.TypeExaminationReycleView);
        LinearLayoutManager layoutManager2 = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        review.setHasFixedSize(true);
        review.setLayoutManager(layoutManager2);
        reviewDoctorProfileLists=new ArrayList<>();

            ReviewDoctorProfileList reviewDoctorProfileList=new ReviewDoctorProfileList("Ali","15-10-2020",5f,"Good Doctor");
            reviewDoctorProfileLists.add(reviewDoctorProfileList);
         reviewDoctorProfileList=new ReviewDoctorProfileList("Nader","30-10-2020",2.5f,"the worst Doctor Ever");
        reviewDoctorProfileLists.add(reviewDoctorProfileList);
         reviewDoctorProfileList=new ReviewDoctorProfileList("salma","20-6-2020",3.5f,"Nice");
        reviewDoctorProfileLists.add(reviewDoctorProfileList);

        reviewDoctorProfileAdaptor=new ReviewDoctorProfileAdaptor(getApplicationContext(),reviewDoctorProfileLists);
        review.setAdapter(reviewDoctorProfileAdaptor);

    }
}
