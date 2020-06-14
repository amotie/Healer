package com.amotie.healer;

import android.graphics.Bitmap;

public class DoctorHomeListItem {
    public Bitmap image;
    public String name;
    public String spesialist;

    DoctorHomeListItem(Bitmap image,String name,String spesialist){
        this.image=image;
        this.name=name;
        this.spesialist=spesialist;
    }
}