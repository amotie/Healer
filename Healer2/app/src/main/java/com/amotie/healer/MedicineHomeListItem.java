package com.amotie.healer;

import android.graphics.Bitmap;

public class MedicineHomeListItem {
    Bitmap image;
    String name;
    String description;

    MedicineHomeListItem(Bitmap image,String name,String description){
        this.image=image;
        this.name=name;
        this.description=description;
    }
}
