package com.amotie.healer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Deals extends Fragment {
    TabLayout tabLayout;
    TabItem shcaduled,history;
    PageAdaptorDeals pageAdaptorDeals;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.deals,container,false);
        tabLayout=(TabLayout)view.findViewById(R.id.TaplayoutDeals);
        shcaduled=(TabItem)view.findViewById(R.id.ScheduledDeals);
        history=(TabItem)view.findViewById(R.id.HistoryDeals);
        viewPager=(ViewPager)view.findViewById(R.id.ViewPagerDeals);
        pageAdaptorDeals=new PageAdaptorDeals(getChildFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdaptorDeals);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return view;
    }

}
