package com.amotie.healer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdaptorDeals extends FragmentPagerAdapter {
    int numberofTapes;
    public PageAdaptorDeals(@NonNull FragmentManager fm, int numberofTapes) {
        super(fm);
        this.numberofTapes=numberofTapes;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SchaduledDeals();
            case 1:
                return new HistoryDeals();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberofTapes;
    }
}
