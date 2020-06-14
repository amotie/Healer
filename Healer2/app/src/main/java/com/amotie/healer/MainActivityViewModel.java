package com.amotie.healer;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    Fragment selectedFragment =new Home();
    public void setSelectedFragment(Fragment selectedFragment){
       this.selectedFragment =selectedFragment;
    }
    public Fragment getSelectedFragment(){
        return selectedFragment;
    }
}
