package com.amotie.healer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class DoctorSpicalistAdabtor extends BaseAdapter {
    Context context;
    List<DoctorSpicialistListHeal> doctorSpicalistList;
    public DoctorSpicalistAdabtor(Context context, List<DoctorSpicialistListHeal> doctorSpicalistList){
        this.context=context;
        this.doctorSpicalistList=doctorSpicalistList;
    }
    @Override
    public int getCount() {
        return doctorSpicalistList.size();
    }

    @Override
    public Object getItem(int position) {
        return doctorSpicalistList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.doctor_spicilist_list,parent,false);
        ImageView imageView =row.findViewById(R.id.DoctorImageGridView);
        TextView spicialest =row.findViewById(R.id.DoctorSpiialsstGridView);
        imageView.setImageBitmap(doctorSpicalistList.get(position).image);
        if(doctorSpicalistList.get(position).image == null){
            Log.i("image","empty");
        }
//            imageView.setImageResource(R.drawable.ic_testing_glasses);
        spicialest.setText(doctorSpicalistList.get(position).name);
        return row;
    }
}
