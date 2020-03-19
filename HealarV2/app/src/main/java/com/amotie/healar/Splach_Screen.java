package com.amotie.healar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splach_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach__screen);
        Thread thread =new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
//                    SharedPreferences sharedPreferences =getSharedPreferences("userInfo",MODE_PRIVATE);

//                    if(sharedPreferences.getString("username","").length()==0){
                 /*       Network network=new Network();
                        network.execute(sharedPreferences.getString("username",""),sharedPreferences.getString("password",""));
*/
//                        Intent intent=new Intent(getApplicationContext(),Login.class);
//                        startActivity(intent);
//                    }
//                    else {


                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

//                    }
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();

    }
}

