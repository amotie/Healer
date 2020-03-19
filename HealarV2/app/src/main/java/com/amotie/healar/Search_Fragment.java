package com.amotie.healar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class Search_Fragment extends Fragment {

    RecyclerView result;
    RecyclerView.Adapter adapter;
    private List<SearchListitem> searchListitems;
    Bitmap doctorImage;
    MaterialSearchView searchView;
    CardView searchCard;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.search_fragment,container,false);
        searchCard=(CardView)view.findViewById(R.id.SearchCardView);
        searchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.performClick();
              searchView.showSearch(true);
            }
        });
        searchView =(MaterialSearchView)view.findViewById(R.id.SearchView);



        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {

                //Do some magic
            }
        });
//        catigoresBtn=(Button)view.findViewById(R.id.CategoriesBtn);
//        rateBtn=(Button)view.findViewById(R.id.RateBtn);
//        catigoresBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SearchBottomSheeetCatigores searchBottomSheeetCatigores=new SearchBottomSheeetCatigores();
//
//                searchBottomSheeetCatigores.show(getFragmentManager(),"catigores");
//
//            }
//        });
//        rateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        result = (RecyclerView)view.findViewById(R.id.SearchResult);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        result.setHasFixedSize(true);
        result.setLayoutManager(layoutManager);
        searchListitems=new ArrayList<>();
        doctorImage= BitmapFactory.decodeResource(getResources(),R.drawable.doctor);

        for (int i=0;i<=100;i++){

            SearchListitem searchListitem=new SearchListitem(doctorImage,"ALi Motie","Dentest","0.5KM","3.5");

            searchListitems.add(searchListitem);
        }
        adapter=new SearchAdaptor(searchListitems,getContext());
        result.setAdapter(adapter);


        return view;
    }


}
