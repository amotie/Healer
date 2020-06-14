package com.amotie.healer;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Calendar;

public class SignUpViewModel extends ViewModel {
    public boolean ValidateUsername(String username){
        if (username.matches("[a-zA-Z\\s]+")){
            return true;
        }
        else{
            return false;
        }
    }
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
    public boolean ValidateDay(String day){
        if(!day.isEmpty()) {
            int d = Integer.parseInt(day);
            if (d > 0 && d < 32) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }
    public boolean ValidateMonth(String month, String day){
        if(!day.isEmpty()&&!month.isEmpty()) {
            int d = Integer.parseInt(day);
            int m = Integer.parseInt(month);
            if (m > 0 && m < 13) {
                if (m == 1 || m == 3 || m == 5 || m == 7 || m == 9 || m == 11) {
                    if (d > 0 && d < 32) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (m == 2) {
                    if (d > 0 && d < 29) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (d > 0 && d < 31) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public boolean ValidateYear(String year){
        if(!year.isEmpty()) {
            int y = Integer.parseInt(year);
            int thisYear = Calendar.getInstance().get(Calendar.YEAR);
            if (y <= thisYear && y > 1900) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public boolean ValidatePhone(String phone){
        if (phone.matches("^(010|011|012)[0-9]{8}$")){
            return true;
        }
        else{
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
    public boolean ValidatePasswordConfirm(String password,String confirmPassword){
        if (!confirmPassword.isEmpty()) {
            if (password.equals(confirmPassword)) {
                Log.i("SIGNUP","TRUE");
                return true;

            } else {
                Log.i("SIGNUP","FALSE");
                return false;
            }
        }
        else {
            Log.i("SIGNUP","FALSEALL");
            return false;
        }
    }
    public boolean Validate(String username, String email, String day ,String month, String year, String phone, String password,String confirmPassword){
       if (ValidateUsername(username) &&  ValidateEmail(email)
            && ValidateDay(day) && ValidateMonth(month,day)
            &&  ValidateYear(year) && ValidatePhone(phone)
            && ValidatePassword(password) && ValidatePasswordConfirm(password,confirmPassword)){
           return true;
       }
       else{
           return false;
       }

    }

}
