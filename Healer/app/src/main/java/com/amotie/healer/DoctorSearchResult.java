package com.amotie.healer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DoctorSearchResult extends Fragment {
    RecyclerView doctorList;
    RecyclerView.Adapter adapter;
    private List<DoctorListItem> doctorListItems;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.doctor_search_result,container,false);
        doctorList=(RecyclerView)view.findViewById(R.id.DoctorList);
        doctorList.setHasFixedSize(true);
        doctorList.setLayoutManager(new LinearLayoutManager(getContext()));
        doctorListItems=new ArrayList<>();
        for (int i=0;i<=100;i++){

            DoctorListItem doctorListItem=new DoctorListItem("ALi","cairo,nasr City" );
            doctorListItems.add(doctorListItem);
        }
        adapter=new DoctorAdaptor(doctorListItems,getContext());
        doctorList.setAdapter(adapter);

        return view;
    }
}
