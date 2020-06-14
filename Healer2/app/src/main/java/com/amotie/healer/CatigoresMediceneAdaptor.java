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

public class CatigoresMediceneAdaptor extends BaseAdapter {
    Context context;
    List<CatigoresMediceneListHeal> catigoresMediceneListHealList;
    public CatigoresMediceneAdaptor(Context context, List<CatigoresMediceneListHeal> catigoresMediceneListHealList){
        this.context=context;
        this.catigoresMediceneListHealList=catigoresMediceneListHealList;
    }
    @Override
    public int getCount() {
        return catigoresMediceneListHealList.size();
    }

    @Override
    public Object getItem(int position) {
        return catigoresMediceneListHealList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.categories_medicences_list,parent,false);
        ImageView imageView =row.findViewById(R.id.CategoresImageGridView);
        TextView spicialest =row.findViewById(R.id.CategoryName);
        imageView.setImageBitmap(catigoresMediceneListHealList.get(position).image);
        if(catigoresMediceneListHealList.get(position).image == null){
            Log.i("image","empty");
        }
//            imageView.setImageResource(R.drawable.ic_testing_glasses);
        spicialest.setText(catigoresMediceneListHealList.get(position).name);
        return row;
    }
}
