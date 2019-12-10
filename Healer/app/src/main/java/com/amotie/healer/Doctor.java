package com.amotie.healer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        BottomNavigationView navView = findViewById(R.id.navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmetControl,new DoctorFragment()).commit();
        navView.setOnNavigationItemSelectedListener(selectedListener);

        navView.setItemIconTintList(null);

    }

    public void Search(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmetControl,new DoctorSearchResult()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment=null;
            switch (menuItem.getItemId()){
                case R.id.navigationDoctor:
                    selectedFragment=new DoctorFragment();
                    break;
                case R.id.navigationMedicine:
                    selectedFragment=new MediceneFragment();
                    break;
                case R.id.navigationHospital:
                    selectedFragment=new HospitalFragmenrt();
                    break;
                case R.id.navigationEmergency:
                    selectedFragment=new EmergancyFragment();
                    break;
                case R.id.navigationNearby:
                    selectedFragment=new NearbyFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmetControl,selectedFragment).commit();
            return true;
        }
    };
}
