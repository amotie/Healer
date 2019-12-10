package com.amotie.healer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DoctorFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.doctorfragmint,container,false);
        Spinner doctorSpichalList =(Spinner)view.findViewById(R.id.DoctorSpicialList);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.DoctorSpecialList,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        doctorSpichalList.setAdapter(adapter);
        Spinner doctorGenderList =(Spinner)view.findViewById(R.id.DoctorGenderList);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getContext(),R.array.Gender,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        doctorGenderList.setAdapter(adapter1);

        return view;
    }
}
