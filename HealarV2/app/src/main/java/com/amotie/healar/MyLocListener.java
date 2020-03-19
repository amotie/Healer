package com.amotie.healar;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocListener implements LocationListener {
    Double Longitude,Latitude;
    @Override
    public void onLocationChanged(Location location) {
        if(location!=null){
        Longitude=location.getLongitude();
        Latitude= location.getLatitude();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
