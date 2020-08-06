package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();

    }
    public void MedicalHistory(View view){
        Intent intent=new Intent(getApplicationContext(),YourExaminations.class);
        startActivity(intent);
    }
}