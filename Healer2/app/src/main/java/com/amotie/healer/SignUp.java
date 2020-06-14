package com.amotie.healer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity implements TextView.OnEditorActionListener{
    TextInputLayout usernameLayout,
            emailLayout,
            dayLayout,
            monthLayout,
            yearLayout,
            phoneLayout,
            passwordLayout,
            confermPasswordLayout;
    TextInputEditText usernameEdit,
            emailEdit,
            dayEdit,
            monthEdit,
            yearEdit,
            phoneEdit,
            passwordEdit,
            confermPasswordEdit;
    RadioGroup gender;
    TextView genderNotSelected;
    SignUpViewModel signUpViewModel;
    Button signup;
    ProgressBar looding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        usernameLayout=(TextInputLayout) findViewById(R.id.usernamelayout);
        emailLayout=(TextInputLayout) findViewById(R.id.emailLayout);
        dayLayout=(TextInputLayout) findViewById(R.id.dayLayout);
        monthLayout=(TextInputLayout) findViewById(R.id.monthLayout);
        yearLayout=(TextInputLayout) findViewById(R.id.yearLayout);
        phoneLayout=(TextInputLayout) findViewById(R.id.phoneLayout);
        passwordLayout=(TextInputLayout) findViewById(R.id.passwordlayout);
        confermPasswordLayout=(TextInputLayout) findViewById(R.id.passwordConfermLayout);
        usernameEdit=(TextInputEditText)findViewById(R.id.usernameEditText);
        emailEdit=(TextInputEditText)findViewById(R.id.emailEditText);
        dayEdit=(TextInputEditText)findViewById(R.id.dayInput);
        monthEdit=(TextInputEditText)findViewById(R.id.monthEdit);
        yearEdit=(TextInputEditText)findViewById(R.id.yearEdit);
        phoneEdit=(TextInputEditText)findViewById(R.id.phoneEdit);
        passwordEdit=(TextInputEditText)findViewById(R.id.passwordEdit);
        confermPasswordEdit=(TextInputEditText)findViewById(R.id.passwordConfermEdit);
        gender=(RadioGroup)findViewById(R.id.gender);
        genderNotSelected=(TextView)findViewById(R.id.genderNotSelected);
        usernameEdit.setOnEditorActionListener(this);
        emailEdit.setOnEditorActionListener(this);
        dayEdit.setOnEditorActionListener(this);
        monthEdit.setOnEditorActionListener(this);
        yearEdit.setOnEditorActionListener(this);
        phoneEdit.setOnEditorActionListener(this);
        passwordEdit.setOnEditorActionListener(this);
        confermPasswordEdit.setOnEditorActionListener(this);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(gender.getCheckedRadioButtonId()!= -1){
                    genderNotSelected.setVisibility(View.GONE);
                }
                else{
                    genderNotSelected.setVisibility(View.VISIBLE);
                }
            }
        });
        signup=(Button)findViewById(R.id.SignUp);
        looding=(ProgressBar)findViewById(R.id.progressBar);
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
    }

    public void SignUp(View view){
        if (signUpViewModel.Validate(usernameEdit.getText().toString(),
            emailEdit.getText().toString(),
            dayEdit.getText().toString(),
                    monthEdit.getText().toString(),
                    yearEdit.getText().toString(),
                    phoneEdit.getText().toString(),
                    passwordEdit.getText().toString(),
                    confermPasswordEdit.getText().toString())){
            if (gender.getCheckedRadioButtonId()!= -1) {
                genderNotSelected.setVisibility(View.GONE);
                signup.setText("");
                looding.setVisibility(View.VISIBLE);
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }else{
                genderNotSelected.setVisibility(View.VISIBLE);
            }
        }
        else{
            if (signUpViewModel.ValidateUsername(usernameEdit.getText().toString())){
                usernameLayout.setErrorEnabled(false);
            }
            else {
                usernameLayout.setError(getText(R.string.usernameNotValide));
            }
            if (signUpViewModel.ValidateEmail(emailEdit.getText().toString())){
                emailLayout.setErrorEnabled(false);
            }
            else {
                emailLayout.setError(getText(R.string.EmailisNotValid));
            }
            if (signUpViewModel.ValidateDay(dayEdit.getText().toString())){
                dayLayout.setErrorEnabled(false);
            }
            else{
                dayLayout.setError(getText(R.string.dayNotValide));
            }
            if (signUpViewModel.ValidateMonth(monthEdit.getText().toString(),dayEdit.getText().toString())){
                monthLayout.setErrorEnabled(false);
            }
            else{
                monthLayout.setError(getText(R.string.monthNotValide));
            }
            if (signUpViewModel.ValidateYear(yearEdit.getText().toString())){
                yearLayout.setErrorEnabled(false);
            }
            else{
                yearLayout.setError(getText(R.string.yearNotValide));
            }
            if (signUpViewModel.ValidatePhone(phoneEdit.getText().toString())){
                phoneLayout.setErrorEnabled(false);
            }
            else{
                phoneLayout.setError(getText(R.string.phoneNotValide));
            }
            if (signUpViewModel.ValidatePassword(passwordEdit.getText().toString())){
                passwordLayout.setErrorEnabled(false);
            }
            else{
                passwordLayout.setError(getText(R.string.passwordNotValide));
            }
            if (signUpViewModel.ValidatePasswordConfirm(passwordEdit.getText().toString(),confermPasswordEdit.getText().toString())){
                confermPasswordLayout.setErrorEnabled(false);
            }
            else {
                confermPasswordLayout.setError(getText(R.string.passwordNotValide));
            }
            if (gender.getCheckedRadioButtonId()!= -1){
                genderNotSelected.setVisibility(View.GONE);
            }
            else{
                genderNotSelected.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (v.getId()){
            case R.id.usernameEditText:
                    if (actionId == EditorInfo.IME_ACTION_NEXT){
                        if (signUpViewModel.ValidateUsername(usernameEdit.getText().toString())){
                            usernameLayout.setErrorEnabled(false);
                        }
                        else {
                            usernameLayout.setError(getText(R.string.usernameNotValide));
                        }
                    }
                    break;
            case R.id.emailEditText:
                    if (actionId == EditorInfo.IME_ACTION_NEXT){
                        if (signUpViewModel.ValidateEmail(emailEdit.getText().toString())){
                            emailLayout.setErrorEnabled(false);
                        }
                        else {
                            emailLayout.setError(getText(R.string.EmailisNotValid));
                        }
                    }
                    break;
            case R.id.dayInput:
                    if (actionId == EditorInfo.IME_ACTION_NEXT){
                        if (signUpViewModel.ValidateDay(dayEdit.getText().toString())){
                            dayLayout.setErrorEnabled(false);
                        }
                        else{
                            dayLayout.setError(getText(R.string.dayNotValide));
                        }
                        monthLayout.requestFocus();
                    }
                break;
            case R.id.monthEdit:
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    if (signUpViewModel.ValidateMonth(monthEdit.getText().toString(),dayEdit.getText().toString())){
                        monthLayout.setErrorEnabled(false);
                    }
                    else{
                        monthLayout.setError(getText(R.string.monthNotValide));
                    }
                    yearLayout.requestFocus();
                    break;
                }
            case R.id.yearEdit:
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    if (signUpViewModel.ValidateYear(yearEdit.getText().toString())){
                        yearLayout.setErrorEnabled(false);
                    }
                    else{
                        yearLayout.setError(getText(R.string.yearNotValide));
                    }
                    phoneLayout.requestFocus();
                    break;
                }
            case R.id.phoneEdit:
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    if (signUpViewModel.ValidatePhone(phoneEdit.getText().toString())){
                        phoneLayout.setErrorEnabled(false);
                    }
                    else{
                        phoneLayout.setError(getText(R.string.phoneNotValide));
                    }
                    passwordLayout.requestFocus();
                    break;
                }
            case R.id.passwordEdit:
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    if (signUpViewModel.ValidatePassword(passwordEdit.getText().toString())){
                        passwordLayout.setErrorEnabled(false);
                    }
                    else{
                        passwordLayout.setError(getText(R.string.passwordNotValide));
                    }
                    confermPasswordLayout.requestFocus();
                    break;
                }
            case R.id.passwordConfermEdit:
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    if (signUpViewModel.ValidatePasswordConfirm(passwordEdit.getText().toString(),confermPasswordEdit.getText().toString())){
                        confermPasswordLayout.setErrorEnabled(false);
                    }
                    else {
                        confermPasswordLayout.setError(getText(R.string.passwordNotValide));
                    }
                }
                break;

        }
        return false;
    }
}
