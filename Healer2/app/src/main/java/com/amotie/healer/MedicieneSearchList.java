package com.amotie.healer;

import android.graphics.Bitmap;

public class MedicieneSearchList {
    Bitmap image;
    String name;
    String provider;
    String price;

    MedicieneSearchList(Bitmap image,String name,String provider,String price){
        this.image=image;
        this.name=name;
        this.provider=provider;
        this.price=price;

    }
}
