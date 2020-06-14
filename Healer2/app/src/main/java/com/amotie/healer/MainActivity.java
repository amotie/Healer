package com.amotie.healer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
        SearchView searchView=(SearchView)search.getActionView();
        searchView.setQueryHint("Search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
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
