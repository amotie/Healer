package com.amotie.healer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity  implements TextView.OnEditorActionListener {
    TextInputLayout email,password;
    TextInputEditText emailEditText,passwordEditText;
    LoginViewModel loginViewModel;
    Button signIn;
    ProgressBar looding;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(TextInputLayout)findViewById(R.id.email1);
        password=(TextInputLayout)findViewById(R.id.password);
        emailEditText=(TextInputEditText)findViewById(R.id.emailEdetText);
        passwordEditText=(TextInputEditText)findViewById(R.id.passwordEditText);
        looding=(ProgressBar)findViewById(R.id.progressBar);
        signIn=(Button)findViewById(R.id.SignIn);
        emailEditText.setOnEditorActionListener(this);
        passwordEditText.setOnEditorActionListener(this);
        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);


    }
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        Log.i("Main", String.valueOf(v.getId()));
        Log.i("Main", String.valueOf(R.id.passwordEditText));
        switch (v.getId()){
            case R.id.emailEdetText:
                Log.i("main","email");
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                   if (loginViewModel.ValidateEmail(emailEditText.getText().toString())){
                       email.setErrorEnabled(false);
                   }
                   else{
                       email.setError(getText(R.string.EmailisNotValid));
                   }

                }

            case R.id.passwordEditText:
                Log.i("main","password");
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (loginViewModel.ValidatePassword(passwordEditText.getText().toString())){
                        password.setErrorEnabled(false);
                        Signin(v);
                    }
                    else{
                        password.setError(getText(R.string.PasswordisNotValid));
                    }

                }

        }
        return false;
    }
    @SuppressLint("ResourceType")
    public void Signin(View view){
        Log.i("SignIn","SignIn");
        if(loginViewModel.ValidateEmail(email.getEditText().getText().toString())){
            //Email Is Right
            if(loginViewModel.ValidatePassword(password.getEditText().getText().toString())){
                //Password Is Right
                email.setErrorEnabled(false);
                password.setErrorEnabled(false);
                signIn.setText("");
                looding.setVisibility(View.VISIBLE);
            }
            else{
                //Email Is Right But Password Is Wrong
                email.setErrorEnabled(false);
                password.setError(getText(R.string.PasswordisNotValid));
            }
        }
        else{
            //Email Is Wrong
            if(loginViewModel.ValidatePassword(password.getEditText().getText().toString())){
                //Email Is Wrong Password Is Right
                email.setError(getText(R.string.EmailisNotValid));

                password.setErrorEnabled(false);
            }
            else{
                //Email Is Wrong But Password Is Wrong
                email.setError(getText(R.string.EmailisNotValid));
                password.setError(getText(R.string.EmailisNotValid));
            }
        }
    }
    public void ForgetPassword(View view){
        AlertDialog.Builder mbelder=new AlertDialog.Builder(Login.this);
        View view1=getLayoutInflater().inflate(R.layout.forget_password_alart_dilog,null);
        ImageButton close=(ImageButton)view1.findViewById(R.id.close);
        final TextInputLayout email=(TextInputLayout)view1.findViewById(R.id.email1);
        final TextInputEditText emailEditText=(TextInputEditText)view1.findViewById(R.id.emailedit);
        Button resetPassword=(Button)view1.findViewById(R.id.resetPasswordBtn);
        mbelder.setView(view1);
        final AlertDialog dialog=mbelder.create();
        dialog.show();
        emailEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (loginViewModel.ValidateEmail(emailEditText.getText().toString())){
                        email.setErrorEnabled(false);
                        dialog.cancel();

                    }
                    else{
                        email.setError(getText(R.string.EmailisNotValid));
                    }

                }
                return false;
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginViewModel.ValidateEmail(email.getEditText().getText().toString())){
                    Log.i("main","done");
                    email.setErrorEnabled(false);
                    dialog.cancel();
                }
                else {
                    Log.i("main","else");
                    email.setError(getText(R.string.EmailisNotValid));
                }

            }
        });

    }
    public void SignUp(View view){
        Intent intent=new Intent(getApplicationContext(),SignUp.class);
        startActivity(intent);
    }

}
