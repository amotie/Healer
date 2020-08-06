package com.amotie.healer;

import android.graphics.Bitmap;

public class CartLIst {
    Bitmap image;
    String name;
    String provider;
    String count;
    String price;
   public CartLIst(Bitmap image,String name,String provider,String count,String price){
        this.image=image;
        this.name=name;
        this.provider=provider;
        this.count=count;
        this.price=price;
    }


}
