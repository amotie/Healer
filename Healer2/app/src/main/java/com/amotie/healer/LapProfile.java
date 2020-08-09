package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class LapProfile extends AppCompatActivity {
    RecyclerView typeofExamination,availabledate,availabletime,review;

    List<TypesOfExamination> typesOfExaminations;
    List<AvailalbleDatesLapProfileList> availalbleDatesLapProfileLists;
    List<String> availavleTimesDoctorProfileList;
    List<ReviewLapProfileList> reviewLapProfileLists;
    TypesOfExaminationAdaptor typesOfExaminationAdaptor;
    AvailableDatesLapProfileAdaptor availableDatesLapProfileAdaptor;
    AvailableTimeDoctorprofileAdaptor availableTimeDoctorprofileAdaptor;
    ReviewLapProfileAdaptor reviewLapProfileAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap_profile);
        getSupportActionBar().hide();
        typeofExamination=(RecyclerView)findViewById(R.id.TypeExaminationReycleView);
        LinearLayoutManager layoutManager2 = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        typeofExamination.setHasFixedSize(true);
        typeofExamination.setLayoutManager(layoutManager2);
        typesOfExaminations=new ArrayList<>();
        TypesOfExamination typesOfExamination=new TypesOfExamination("Pboby CR and Anti-for Covid-19");
        typesOfExaminations.add(typesOfExamination);
         typesOfExamination=new TypesOfExamination("Complete Blood Count (CBC)");
        typesOfExaminations.add(typesOfExamination);
        typesOfExamination=new TypesOfExamination("Liver Function");
        typesOfExamination=new TypesOfExamination("High-Density Lipoprotein (HDL)");
        typesOfExaminations.add(typesOfExamination);
        typesOfExamination=new TypesOfExamination("Low-Desity Lipoprptein Cholesterol (LDL-C)");
        typesOfExaminations.add(typesOfExamination);
        typesOfExaminationAdaptor=new TypesOfExaminationAdaptor(typesOfExaminations,getApplicationContext());
        typeofExamination.setAdapter(typesOfExaminationAdaptor);
//        ----------------------------------------------------TypesOfExamination--------------------------------------------
        availabledate=(RecyclerView)findViewById(R.id.AvailableDateRecycleView);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        availabledate.setHasFixedSize(true);
        availabledate.setLayoutManager(layoutManager);
        availalbleDatesLapProfileLists=new ArrayList<>();

        AvailalbleDatesLapProfileList availalbleDatesLapProfileList=new AvailalbleDatesLapProfileList("MON","28");

        availalbleDatesLapProfileLists.add(availalbleDatesLapProfileList);
        availalbleDatesLapProfileList=new AvailalbleDatesLapProfileList("TOU","29");

        availalbleDatesLapProfileLists.add(availalbleDatesLapProfileList);
        availalbleDatesLapProfileList=new AvailalbleDatesLapProfileList("WEN","30");

        availalbleDatesLapProfileLists.add(availalbleDatesLapProfileList);
        availalbleDatesLapProfileList=new AvailalbleDatesLapProfileList("THE","31");

        availalbleDatesLapProfileLists.add(availalbleDatesLapProfileList);

        availableDatesLapProfileAdaptor=new AvailableDatesLapProfileAdaptor(availalbleDatesLapProfileLists,getApplicationContext());
        availabledate.setAdapter(availableDatesLapProfileAdaptor);
        //        ----------------------------------------------------AvailableDate--------------------------------------------
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
        //        ----------------------------------------------------Review--------------------------------------------
        review=(RecyclerView)findViewById(R.id.reviewReycleView);
        LinearLayoutManager layoutManager3 = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        review.setHasFixedSize(true);
        review.setLayoutManager(layoutManager3);
        reviewLapProfileLists=new ArrayList<>();

        ReviewLapProfileList reviewLapProfileList=new ReviewLapProfileList("Ali","15-10-2020",5f,"Good Doctor");
        reviewLapProfileLists.add(reviewLapProfileList);
        reviewLapProfileList=new ReviewLapProfileList("Nader","30-10-2020",2.5f,"the worst Doctor Ever");
        reviewLapProfileLists.add(reviewLapProfileList);
        reviewLapProfileList=new ReviewLapProfileList("salma","20-6-2020",3.5f,"Nice");
        reviewLapProfileLists.add(reviewLapProfileList);

        reviewLapProfileAdaptor=new ReviewLapProfileAdaptor(getApplicationContext(),reviewLapProfileLists);
        review.setAdapter(reviewLapProfileAdaptor);
    }
}