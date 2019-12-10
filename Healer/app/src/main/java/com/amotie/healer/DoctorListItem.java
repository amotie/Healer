package com.amotie.healer;

import android.widget.ImageView;

import androidx.annotation.Nullable;

public class DoctorListItem {
    private String name;
    private String loction;
    private ImageView profilePecture;
    DoctorListItem(String Name,String Loction,  ImageView ProfilePicture){
        name=Name;
        loction=Loction;
        profilePecture=ProfilePicture;
    }
    DoctorListItem(String Name,String Loction){
        name=Name;
        loction=Loction;

    }

    public String getName() {
        return name;
    }

    public String getLoction() {
        return loction;
    }

    public ImageView getProfilePecture() {
        return profilePecture;
    }
}
