package com.amotie.healer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contaner,
                mainActivityViewModel.getSelectedFragment()).commit();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        MenuItem search=menu.findItem(R.id.search_Icon);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search_Icon:
                Intent intent=new Intent(getApplicationContext(),Search.class);
                startActivity(intent);
                break;
            case R.id.cart_Icon:
                Intent intent1=new Intent(getApplicationContext(),Cart.class);
                startActivity(intent1);
                break;
            case R.id.setting_Icon:
                Intent intent3=new Intent(getApplicationContext(),Settings.class);
                startActivity(intent3);

        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()){
                case R.id.home:
                    mainActivityViewModel.setSelectedFragment(new Home());
                    break;
                case R.id.heal:
                    mainActivityViewModel.setSelectedFragment(new Heal());
                    break;
                case R.id.deals:
                    mainActivityViewModel.setSelectedFragment(new Deals());
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contaner,
                    mainActivityViewModel.getSelectedFragment()).commit();
            return true;
        }
    };

    @Override
    protected void onResume() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contaner,
                mainActivityViewModel.getSelectedFragment()).commit();

        super.onResume();
    }
}
