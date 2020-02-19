package com.amotie.healar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import static com.amotie.healar.R.*;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        email=(EditText)findViewById(id.email);
        password=(EditText)findViewById(id.password);
        login=(Button)findViewById(id.Login);
        email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                    if(email.getText().toString().trim().matches(emailPattern)) {
                        email.setBackground(getDrawable(drawable.cerclreborder));
                        password.requestFocus();


                    }
                    else{
                        email.setBackground(getDrawable(drawable.cerclrebordereror));
                    }

                    return true;
                }
                return false;
            }
        });
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    Login(v);
                    return true;
                }
                return false;
            }
        });
    }
    public void Login(View view){
        Intent intent =new Intent(getApplicationContext(), NavigtionBar.class);
        startActivity(intent);
    }
    public void ForgetPassword(View view){

    }
    public void SignUp(View view){
        Intent intent =new Intent(getApplicationContext(),SignUp.class);
        startActivity(intent);
    }
}
