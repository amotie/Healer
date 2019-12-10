package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class ProfileDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        NumberPicker weightPiker=(NumberPicker)findViewById(R.id.WeightPicker);
        weightPiker.setMinValue(1);
        weightPiker.setMaxValue(300);
        weightPiker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });
        NumberPicker heightPiker=(NumberPicker)findViewById(R.id.HeightPicker);
        heightPiker.setMinValue(1);
        heightPiker.setMaxValue(200);
        heightPiker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });
        NumberPicker geanderPiker =(NumberPicker)findViewById(R.id.GenderPicker);
        geanderPiker.setMinValue(0);
        geanderPiker.setMaxValue(2);
        geanderPiker.setDisplayedValues(new String[]{"Male","Female","others"});
        geanderPiker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

            }
        });

        }
        public void Next(View view){
            Intent intent=new Intent(this,Home.class);
            startActivity(intent);
        }
    }

