package com.amotie.healer;

import android.graphics.Bitmap;

public class DoctorHistoryDealsList {
    Bitmap image;
    String name;
    String specilest;
    String time;
    String location;
    String price;
    DoctorHistoryDealsList(Bitmap image,String name,String specilest,String time,String location,String price){
        this.image=image;
        this.name=name;
        this.specilest=specilest;
        this.time=time;
        this.location=location;
        this.price=price;
    }
}
