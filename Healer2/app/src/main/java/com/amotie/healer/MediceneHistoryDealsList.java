package com.amotie.healer;

import android.graphics.Bitmap;

public class MediceneHistoryDealsList {
    Bitmap image;
    String name;
    String provider;
    String expectedDelivery;
    MediceneHistoryDealsList(Bitmap image,String name,String provider,String expectedDelivery){
        this.image=image;
        this.name=name;
        this.provider=provider;
        this.expectedDelivery=expectedDelivery;
    }
}
