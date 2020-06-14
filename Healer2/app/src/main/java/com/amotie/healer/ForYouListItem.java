package com.amotie.healer;
import android.graphics.Bitmap;


public class ForYouListItem {

    public Bitmap image;
    public String name;
    public String description;

    ForYouListItem(Bitmap image,String name,String description){
        this.image=image;
        this.name=name;
        this.description=description;
    }

}

