package com.amotie.healer;

import android.graphics.Bitmap;

public class MedicineSchauledDealList {
    Bitmap image;
    String name;
    String provider;
    String expectedDelivery;
    MedicineSchauledDealList(Bitmap image,String name,String provider,String expectedDelivery){
        this.image=image;
        this.name=name;
        this.provider=provider;
        this.expectedDelivery=expectedDelivery;
    }
}
