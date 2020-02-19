package com.amotie.healar;

import android.graphics.Bitmap;

public class DoctorHomeListItem {
    Bitmap image;
    String name;
    String spesialist;

    DoctorHomeListItem(Bitmap image,String name,String spesialist){
        this.image=image;
        this.name=name;
        this.spesialist=spesialist;
    }
}
