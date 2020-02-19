package com.amotie.healar;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SearchBottomSheeetCatigores extends BottomSheetDialogFragment {
    RadioGroup categories;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.search_bottom_sheet_catigores,container,false);

       categories=(RadioGroup)view.findViewById(R.id.CategoriesFilter);
       categories.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch(checkedId) {
                   case R.id.DoctorFilter:
                       // switch to fragment 1
                       break;
                   case R.id.PharmacyFilter:
                       // Fragment 2
                       break;
                   case R.id.LapsFilter:
                       // Fragment 2
                       break;
               }
           }
       });
        return view;
    }

}
