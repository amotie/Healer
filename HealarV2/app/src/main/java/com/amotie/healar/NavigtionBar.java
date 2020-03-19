package com.amotie.healar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.BubbleToggleView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class NavigtionBar extends AppCompatActivity {
    BubbleNavigationConstraintView bubbleNavigationLinearView;
    Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigtion_bar);

        bubbleNavigationLinearView =(BubbleNavigationConstraintView) findViewById(R.id.top_navigation_constraint);


        if (selectedFragment==null){

            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(R.id.fragmetControl,new Home_Fragment()).commit();

            manager.popBackStack();
           System.out.println("SADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        }

        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                 selectedFragment=null;
                switch (view.getId()){
                    case R.id.l_item_home:

                    selectedFragment=new Home_Fragment();

                        break;
                    case R.id.l_item_Search:
                        selectedFragment=new Search_Fragment();
                        break;
                    case R.id.l_item_Profile:
                        selectedFragment=new Profile_Fragment();
                        break;
                    case R.id.l_item_Settings:
                        selectedFragment=new Settings_Fragment();
                        break;


                }
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.fragmetControl,selectedFragment).commit();

                manager.popBackStack();
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmetControl,selectedFragment).addToBackStack(null).commit();
//                System.out.println("55555555555555555555555555555555555555555");
            }
        });
    }


}
