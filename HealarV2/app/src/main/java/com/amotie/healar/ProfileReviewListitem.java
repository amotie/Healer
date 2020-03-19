package com.amotie.healar;

import android.graphics.Bitmap;

public class ProfileReviewListitem {
    Bitmap profilePicture;
    String name;
    String date;
    float rating;
    String content;
    ProfileReviewListitem(Bitmap profilePicture,String name,String date,float rating,String content){
        this.profilePicture=profilePicture;
        this.name=name;
        this.date=date;
        this.rating=rating;
        this.content=content;
    }
}
