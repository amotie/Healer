package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Search extends AppCompatActivity {
    List<Object> objects;
    RecyclerView search;
    SearchAdapor searchAdapor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        getSupportActionBar().setDisplayShowTitleEnabled(false);
        search=(RecyclerView)findViewById(R.id.SearchRecycle);
        LinearLayoutManager layoutManager2 = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        search.setLayoutManager(layoutManager2);
        objects=new ArrayList<>();
        Bitmap doctor,medicene;
        doctor= BitmapFactory.decodeResource(getResources(),R.drawable.salmafrag);
        medicene= BitmapFactory.decodeResource(getResources(),R.drawable.catflam);
        DoctorSearchList doctorSearchList=new DoctorSearchList(doctor,"Salma Frag","Dentest","200 LE",3.5f);
        objects.add(doctorSearchList);
        MedicieneSearchList medicieneSearchList=new MedicieneSearchList(medicene,"Catflam","Elezaby","20 LE");
        objects.add(medicieneSearchList);
        doctor= BitmapFactory.decodeResource(getResources(),R.drawable.salymohmad);
         doctorSearchList=new DoctorSearchList(doctor,"Saly Mohmed","Dentest","200 LE",3.5f);
        objects.add(doctorSearchList);
        medicene= BitmapFactory.decodeResource(getResources(),R.drawable.augmantien);
         medicieneSearchList=new MedicieneSearchList(medicene,"augmantien","Elezaby","20 LE");
        objects.add(medicieneSearchList);
        searchAdapor=new SearchAdapor(objects,this);
        search.setAdapter(searchAdapor);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_menu_bar,menu);
        MenuItem search=menu.findItem(R.id.search_Icon);
        SearchView searchView=(SearchView) search.getActionView();
        search.expandActionView();
        searchView.setQueryHint("Search");
        searchView.setIconifiedByDefault(false);
        searchView.requestFocus();
        String x=getIntent().getStringExtra("SearchValue");
        CharSequence charSequence=x;
        searchView.setQuery(charSequence,false);
        searchView.onActionViewExpanded();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapor.getFilter().filter(newText);
                return false;
            }
        });




        return true;
    }
}