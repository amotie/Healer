package com.amotie.healer;

import android.graphics.Bitmap;

public class YourExaminationsList {
    Bitmap bitmap;
    String name;
    String bookedDate;
    String status;
    String recived;

    public YourExaminationsList(Bitmap bitmap, String name, String bookedDate, String status, String recived) {
        this.bitmap = bitmap;
        this.name = name;
        this.bookedDate = bookedDate;
        this.status = status;
        this.recived = recived;
    }
}
