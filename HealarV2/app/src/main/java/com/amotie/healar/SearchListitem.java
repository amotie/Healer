package com.amotie.healar;

import android.graphics.Bitmap;

public class SearchListitem {
    Bitmap image;
    String name;
    String spesialist;
    String loction;
    String rating;

    SearchListitem(Bitmap image,String name,String spesialist,String loction,String rating){
        this.image=image;
        this.name=name;
        this.spesialist=spesialist;
        this.loction=loction;
        this.rating=rating;
    }
}
