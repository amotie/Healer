package com.amotie.healar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationHolder;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.basgeekball.awesomevalidation.utility.custom.CustomErrorReset;
import com.basgeekball.awesomevalidation.utility.custom.CustomValidation;
import com.basgeekball.awesomevalidation.utility.custom.CustomValidationCallback;
import com.basgeekball.awesomevalidation.utility.custom.SimpleCustomValidation;

import java.text.ParseException;
import java.util.Calendar;

import javax.xml.validation.Validator;

public class SignUp extends AppCompatActivity {
    EditText birthDate,userName,email,password,passwordConferm,phone;
    RadioGroup gender;
    RadioButton male,female;
    TextView genderNotSelected,passwordNotMatch;
    AwesomeValidation validation;
    TextWatcher textWatcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sign_up);
        birthDate=(EditText)findViewById(R.id.berthDate);
        passwordNotMatch=(TextView)findViewById(R.id.passowrdNotMatch);
        male=(RadioButton)findViewById(R.id.MaleRadioButton);
        female=(RadioButton)findViewById(R.id.FemaleRadioButton);
         textWatcher=new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));

                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon-1);
                        year = (year<1900)?1900:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    birthDate.setText(current);
                    birthDate.setSelection(sel < current.length() ? sel : current.length());
            }


        }

            @Override
            public void afterTextChanged(Editable s) {

            }


    };

    birthDate.addTextChangedListener(textWatcher);
        gender=(RadioGroup)findViewById(R.id.Gender);
        genderNotSelected=(TextView)findViewById(R.id.SelectGenderError);
        userName=(EditText)findViewById(R.id.Username);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        passwordConferm=(EditText)findViewById(R.id.confermPassword);
        passwordConferm.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // if (actionId == EditorInfo.IME_ACTION_NEXT) {
                SignUp(v);
                //}
                return false;
            }
        });
        phone=(EditText)findViewById(R.id.phone);
        validation=new AwesomeValidation(ValidationStyle.BASIC);
        String regexPassword ="(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).{8,}";

        validation.addValidation(SignUp.this,R.id.Username,"[a-zA-Z\\s]+",R.string.userNameError);
        validation.addValidation(SignUp.this,R.id.email,android.util.Patterns.EMAIL_ADDRESS,R.string.EmailError);
        validation.addValidation(SignUp.this,R.id.password,regexPassword,R.string.passworderror);
        validation.addValidation(SignUp.this,R.id.confermPassword, R.id.password,R.string.passwordConfermError);

       // validation.addValidation(SignUp.this,R.id.berthDate,textWatcher.toString(),R.string.berthdateError);
        validation.addValidation(SignUp.this,R.id.phone, "^(010|011|012)[0-9]{8}$",R.string.phoneError);

    }
    public void SignUp(View view){
        if (validation.validate()){
            if(gender.getCheckedRadioButtonId()!=-1) {
                genderNotSelected.setVisibility(View.GONE);
                String gender1;
               if(gender.getCheckedRadioButtonId()==male.getId()){
                   gender1="0";
                   SignUpNetwork signUpNetwork=new SignUpNetwork(this);
                   signUpNetwork.execute(userName.getText().toString()
                           ,email.getText().toString(),
                           phone.getText().toString(),
                           password.getText().toString(),
                           birthDate.getText().toString(),
                           gender1);
               }
               else if(gender.getCheckedRadioButtonId()==female.getId()){
                   gender1="1";
                   SignUpNetwork signUpNetwork=new SignUpNetwork(this);
                   signUpNetwork.execute(userName.getText().toString()
                           ,email.getText().toString(),
                           phone.getText().toString(),
                           password.getText().toString(),
                           birthDate.getText().toString(),
                           gender1);
               }


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
            else{
                genderNotSelected.setVisibility(View.VISIBLE);
            }
        }
        else{
            if(gender.getCheckedRadioButtonId()!=-1) {
              genderNotSelected.setVisibility(View.GONE);
            }
            else{
                genderNotSelected.setVisibility(View.VISIBLE);
            }
        }





    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.MaleRadioButton:
                if (checked)
                    // Pirates are the best
                    genderNotSelected.setVisibility(View.GONE);
                    break;
            case R.id.FemaleRadioButton:
                if (checked)
                    genderNotSelected.setVisibility(View.GONE);
                    break;
        }
    }


}
