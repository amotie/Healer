package com.amotie.healar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.custom.SimpleCustomValidation;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountSettingsBottomSheet extends BottomSheetDialogFragment {
    EditText username,email,phone,birthday;
    CardView profilePictureChange;
    CircleImageView profilePicture;
    RadioGroup gender;
    TextView genderNotSelected;
    Button save;
    AwesomeValidation validation;

    public static final int PICK_IMAGE = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.account_settings,container,false);
        profilePictureChange=(CardView)view.findViewById(R.id.changeProfilePicture);
        profilePicture=(CircleImageView)view.findViewById(R.id.profilePicture);
        username=(EditText)view.findViewById(R.id.Username);
        email=(EditText)view.findViewById(R.id.email);
        phone=(EditText)view.findViewById(R.id.phone);
        birthday=(EditText)view.findViewById(R.id.berthDate);
        genderNotSelected=(TextView)view.findViewById(R.id.SelectGenderError);
        save=(Button)view.findViewById(R.id.accountSave);
        gender=(RadioGroup)view.findViewById(R.id.Gender);
        validation=new AwesomeValidation(ValidationStyle.BASIC);

        profilePictureChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.MaleRadioButton:

                            // Pirates are the best
                            genderNotSelected.setVisibility(View.GONE);
                        break;
                    case R.id.FemaleRadioButton:

                            genderNotSelected.setVisibility(View.GONE);
                        break;
                }
            }
        });


        validation.addValidation(username,"[a-zA-Z\\s]+","Enter Valid UserName");
        validation.addValidation(email,android.util.Patterns.EMAIL_ADDRESS,"Enter Valid E-mail");
        validation.addValidation(phone,"^(010|011|012)[0-9]{8}$","Enter Valid Phone");
        validation.addValidation(birthday,new SimpleCustomValidation() {
            @Override
            public boolean compare(String input) {
                // check if the age is >= 18
                try {
                    Calendar calendarBirthday = Calendar.getInstance();
                    Calendar calendarToday = Calendar.getInstance();
                    calendarBirthday.setTime(new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(input));
                    int yearOfToday = calendarToday.get(Calendar.YEAR);
                    int yearOfBirthday = calendarBirthday.get(Calendar.YEAR);
                    if (yearOfToday - yearOfBirthday > 18) {
                        return true;
                    } else if (yearOfToday - yearOfBirthday == 18) {
                        int monthOfToday = calendarToday.get(Calendar.MONTH);
                        int monthOfBirthday = calendarBirthday.get(Calendar.MONTH);
                        if (monthOfToday > monthOfBirthday) {
                            return true;
                        } else if (monthOfToday == monthOfBirthday) {
                            if (calendarToday.get(Calendar.DAY_OF_MONTH) >= calendarBirthday.get(Calendar.DAY_OF_MONTH)) {
                                return true;
                            }
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return false;
            }
        },"Enter Valid BirthDate");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation.validate()){
                    if(gender.getCheckedRadioButtonId()!=-1) {
                        genderNotSelected.setVisibility(View.GONE);
                        dismiss();
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
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PICK_IMAGE) {

            try {
                InputStream inputStream = getContext().getContentResolver().openInputStream(data.getData());
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                profilePicture.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
