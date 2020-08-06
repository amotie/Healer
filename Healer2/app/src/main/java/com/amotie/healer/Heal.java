package com.amotie.healer;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Heal extends Fragment {
    GridView doctorSpicialest,catigoresMedicene;
    List<DoctorSpicialistListHeal> doctorSpicialistListHeals;
    List<CatigoresMediceneListHeal> catigoresMediceneListHeals;
    Bitmap doctor,catigory,lap;
    DoctorSpicalistAdabtor doctorSpicalistAdabtor;
    CatigoresMediceneAdaptor catigoresMediceneAdaptor;
    RecyclerView laps;
    RecyclerView.Adapter adapter;
    List<LapsHealList> lapsHealLists;
    ProgressDialog dialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.heal,container,false);
//        dialog=new ProgressDialog(getContext());
//        dialog.show();
//        dialog.setContentView(R.layout.lodding);
//        Window window=dialog.getWindow();
//        window.setBackgroundDrawableResource(R.color.colorBackground);
//        window.setLayout(250, 250);
//        dialog.setCancelable(false);
//        -------------------------------------------ProgressBar-----------------------------------------------------
        doctorSpicialest=(GridView)view.findViewById(R.id.DoctorGridView);
        doctorSpicialistListHeals=new ArrayList<>();
        doctor=BitmapFactory.decodeResource(getResources(),R.drawable.doctor);
        if (doctor == null){
            Log.i("Image","Before");
        }
        doctor=BitmapFactory.decodeResource(getResources(),R.drawable.urgology);
            DoctorSpicialistListHeal doctorSpicialistListHeal=new DoctorSpicialistListHeal(doctor,"Urology");
            doctorSpicialistListHeals.add(doctorSpicialistListHeal);
        doctor=BitmapFactory.decodeResource(getResources(),R.drawable.dermatology);
         doctorSpicialistListHeal=new DoctorSpicialistListHeal(doctor,"dermatology");
        doctorSpicialistListHeals.add(doctorSpicialistListHeal);
        doctor=BitmapFactory.decodeResource(getResources(),R.drawable.bone);
         doctorSpicialistListHeal=new DoctorSpicialistListHeal(doctor,"bone");
        doctorSpicialistListHeals.add(doctorSpicialistListHeal);
        doctor=BitmapFactory.decodeResource(getResources(),R.drawable.heart);
         doctorSpicialistListHeal=new DoctorSpicialistListHeal(doctor,"heart");
        doctorSpicialistListHeals.add(doctorSpicialistListHeal);
        doctor=BitmapFactory.decodeResource(getResources(),R.drawable.nose);
         doctorSpicialistListHeal=new DoctorSpicialistListHeal(doctor,"nose");
        doctorSpicialistListHeals.add(doctorSpicialistListHeal);

        doctorSpicalistAdabtor=new DoctorSpicalistAdabtor(getContext(),doctorSpicialistListHeals);
        doctorSpicialest.setAdapter(doctorSpicalistAdabtor);
//        --------------------------------------DoctorSpicialistList--------------------------------------------------
        catigoresMedicene=(GridView)view.findViewById(R.id.CategoriesGridView);
        catigoresMediceneListHeals=new ArrayList<>();
        catigory=BitmapFactory.decodeResource(getResources(),R.drawable.medicinecatigory);

            CatigoresMediceneListHeal catigoresMediceneListHeal=new CatigoresMediceneListHeal(catigory,"Medicines");
            catigoresMediceneListHeals.add(catigoresMediceneListHeal);
        catigory=BitmapFactory.decodeResource(getResources(),R.drawable.bodycare);

         catigoresMediceneListHeal=new CatigoresMediceneListHeal(catigory,"Body Care");
        catigoresMediceneListHeals.add(catigoresMediceneListHeal);
        catigory=BitmapFactory.decodeResource(getResources(),R.drawable.haircare);

        catigoresMediceneListHeal=new CatigoresMediceneListHeal(catigory,"Hair Care");
        catigoresMediceneListHeals.add(catigoresMediceneListHeal);
        catigory=BitmapFactory.decodeResource(getResources(),R.drawable.makeup);

        catigoresMediceneListHeal=new CatigoresMediceneListHeal(catigory,"Makeup");
        catigoresMediceneListHeals.add(catigoresMediceneListHeal);
        catigory=BitmapFactory.decodeResource(getResources(),R.drawable.dudrant);

        catigoresMediceneListHeal=new CatigoresMediceneListHeal(catigory,"Deodorant");
        catigoresMediceneListHeals.add(catigoresMediceneListHeal);
        catigory=BitmapFactory.decodeResource(getResources(),R.drawable.facecare);

        catigoresMediceneListHeal=new CatigoresMediceneListHeal(catigory,"Face Care");
        catigoresMediceneListHeals.add(catigoresMediceneListHeal);
        catigoresMediceneAdaptor=new CatigoresMediceneAdaptor(getContext(),catigoresMediceneListHeals);
        catigoresMedicene.setAdapter(catigoresMediceneAdaptor);
//        ------------------------------------------CatigoresMediceneList-------------------------------------------------
        laps = (RecyclerView)view.findViewById(R.id.LapsHealRecycelView);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        laps.setHasFixedSize(true);
        laps.setLayoutManager(layoutManager);
        lapsHealLists=new ArrayList<>();
        lap= BitmapFactory.decodeResource(getResources(),R.drawable.elmokhtabar);
        LapsHealList lapsHealList=new LapsHealList(lap);

        lapsHealLists.add(lapsHealList);
        lap= BitmapFactory.decodeResource(getResources(),R.drawable.cairolab);
        lapsHealList=new LapsHealList(lap);

        lapsHealLists.add(lapsHealList);
        lap= BitmapFactory.decodeResource(getResources(),R.drawable.alfa);
        lapsHealList=new LapsHealList(lap);

        lapsHealLists.add(lapsHealList);

        adapter=new LapsHealAdaptor(lapsHealLists,getContext());
        laps.setAdapter(adapter);
        return view;
    }


}
