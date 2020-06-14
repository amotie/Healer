package com.amotie.healer;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public boolean ValidateEmail(String email){

        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //Email Matches
            Log.i("LoginViewModel","Done");
            return true;
        }
        else{
            //Email is Wrong

           Log.i("LoginViewModel","fleid");
            return false;
        }
    }
    public boolean ValidatePassword(String password){
        String passwordRagax= "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).{8,}";
        if (password.matches(passwordRagax)){
            //Password Matches
            return true;
        }
        else {
            //Password is Wrong
            return false;
        }
    }


}
