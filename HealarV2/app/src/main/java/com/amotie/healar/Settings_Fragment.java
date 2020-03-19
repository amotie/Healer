package com.amotie.healar;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import javax.xml.validation.Validator;

public class Settings_Fragment extends Fragment {
    CardView myAccount,password,payment,LogOut;
    Switch darkMode;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.settings_fragment,container,false);
        darkMode=(Switch)view.findViewById(R.id.DarkMode);
        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


            }
        });
        password=(CardView)view.findViewById(R.id.passwordCardView);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbelder=new AlertDialog.Builder(getContext());
                View view1=getLayoutInflater().inflate(R.layout.change_password_dialog,null);
                ImageView close=(ImageView)view1.findViewById(R.id.Close);
                final EditText oldPassword=(EditText)view1.findViewById(R.id.oldPassword);
                final EditText newPassword=(EditText)view1.findViewById(R.id.newPassword);
                final EditText confirmPassword=(EditText)view1.findViewById(R.id.confermPassword);
                final Button changePassword=(Button)view1.findViewById(R.id.Change_Password_Btn);
                mbelder.setView(view1);
                final AlertDialog dialog=mbelder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                String regexPassword ="(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).{8,}";
                final AwesomeValidation validation=new AwesomeValidation(ValidationStyle.BASIC);
                validation.addValidation(oldPassword,regexPassword,"Enter Valid Password");
                validation.addValidation(newPassword,regexPassword,"password mast Contain at least one Capital Character and at least 8 Characters ");
                validation.addValidation(confirmPassword,newPassword,"Password Does Not match");
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                changePassword.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(validation.validate()){
                            dialog.cancel();
                        }

                    }
                });

            }
        });
        myAccount=(CardView)view.findViewById(R.id.MyProfile);
        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountSettingsBottomSheet accountSettingsBottomSheet=new AccountSettingsBottomSheet();
                accountSettingsBottomSheet.show(getFragmentManager(),"Account Settings");

            }
        });
        return view;
    }
}
