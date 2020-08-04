package com.amotie.healer;

import android.graphics.Bitmap;

public class DoctorSearchList  {
    Bitmap image;
    String name;
    String specilest;
    String price;
    float rate;
    DoctorSearchList(Bitmap image,String name,String specilest,String price,float rate){
        this.image=image;
        this.name=name;
        this.specilest=specilest;
        this.price=price;
        this.rate=rate;
    }
}
