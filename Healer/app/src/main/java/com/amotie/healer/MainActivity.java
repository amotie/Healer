package com.amotie.healer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void forgetPassword(View view){
        AlertDialog.Builder mbelder=new AlertDialog.Builder(MainActivity.this);
        View view1=getLayoutInflater().inflate(R.layout.forget_password,null);
        ImageView close=(ImageView)view1.findViewById(R.id.Close);
        EditText forgetPassword=(EditText)view1.findViewById(R.id.forgetPassword);
        Button resetpassword=(Button)view1.findViewById(R.id.RestPassword_Btn);
        mbelder.setView(view1);
        final AlertDialog dialog=mbelder.create();
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

    }
    public void signin(View view){
        Intent intent=new Intent(this,Home.class);

        startActivity(intent);

    }
    public void createAccount(View view){
    Intent intent=new Intent(this,SignUp.class);
    startActivity(intent);
    }
}
