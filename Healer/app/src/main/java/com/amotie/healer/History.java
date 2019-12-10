package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class History extends AppCompatActivity {
        private TabLayout tabLayout;
        private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout=(TabLayout)findViewById(R.id.tapsHestory);
        viewPager=(ViewPager)findViewById(R.id.container);
            HistoryAdaptor adaptor=new HistoryAdaptor(getSupportFragmentManager());
            adaptor.AddFragment(new UpcammmingFragment(),"Upcoming");
            adaptor.AddFragment(new PastFragment(),"Past");
            viewPager.setAdapter(adaptor);
            tabLayout.setupWithViewPager(viewPager);
    }
}
