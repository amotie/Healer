package com.amotie.healar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import static com.amotie.healar.R.*;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    ImageView logoImage;
    private static final float[] NEGATIVE = {
            -1.0f,     0,     0,    0, 255, // red
            0, -1.0f,     0,    0, 255, // green
            0,     0, -1.0f,    0, 255, // blue
            0,     0,     0, 1.0f,   0  // alpha
    };
    AwesomeValidation validation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(layout.activity_main);
        email=(EditText)findViewById(id.email);
        password=(EditText)findViewById(id.password);
        login=(Button)findViewById(id.Login);
        logoImage=(ImageView)findViewById(id.logoimage);
        validation=new AwesomeValidation(ValidationStyle.BASIC);
        String regexPassword ="(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).{8,}";
        validation.addValidation(MainActivity.this,R.id.email,android.util.Patterns.EMAIL_ADDRESS,R.string.EmailError);
        validation.addValidation(MainActivity.this,R.id.password,regexPassword,R.string.passworderror);

        // logoImage.setColorFilter(new ColorMatrixColorFilter(NEGATIVE));
//        email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//                if (actionId == EditorInfo.IME_ACTION_NEXT) {
//                    String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//                    if(email.getText().toString().trim().matches(emailPattern)) {
//                        email.setBackground(getDrawable(drawable.cerclreborder));
//                        password.requestFocus();
//
//
//                    }
//                    else{
//                        email.setBackground(getDrawable(drawable.cerclrebordereror));
//                    }
//
//                    return true;
//                }
//                return false;
//            }
//        });
//        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//
//                   // if (actionId == EditorInfo.IME_ACTION_NEXT) {
//                        if(password.getText().toString().isEmpty()){
//                            password.setBackground(getDrawable(drawable.cerclrebordereror)
//                            );
//                        }
//                        else {
//                            password.setBackground(getDrawable(drawable.cerclreborder)
//                            );
//
//                            Login(v);
//                            return true;
//                        }
//                    //}
//
//
//                return false;
//            }
//        });
    }
    public void Login(View view){
      if (validation.validate()){
         Intent intent=new Intent(getApplicationContext(),NavigtionBar.class);
         startActivity(intent);

      }



    }
    public void ForgetPassword(View view){
        AlertDialog.Builder mbelder=new AlertDialog.Builder(MainActivity.this);
        View view1=getLayoutInflater().inflate(R.layout.forget_password,null);
        ImageView close=(ImageView)view1.findViewById(R.id.Close);
        final EditText forgetPassword=(EditText)view1.findViewById(R.id.forgetPassword);
        final Button resetpassword=(Button)view1.findViewById(R.id.RestPassword_Btn);
        mbelder.setView(view1);
        final AlertDialog dialog=mbelder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        final AwesomeValidation validation;
        validation=new AwesomeValidation(ValidationStyle.BASIC);
        validation.addValidation(forgetPassword,android.util.Patterns.EMAIL_ADDRESS,"Enter Valid Email");

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation.validate()){
                    dialog.cancel();

                }

            }
        });

    }
    public void SignUp(View view){
        Intent intent =new Intent(getApplicationContext(),SignUp.class);
        startActivity(intent);

    }


}
