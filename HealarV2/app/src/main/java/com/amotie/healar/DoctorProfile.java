package com.amotie.healar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.audiofx.Equalizer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DoctorProfile extends AppCompatActivity {

    RecyclerView result;
    RecyclerView.Adapter adapter;
    private List<ProfileReviewListitem> profileReviewListitems;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS =1 ;
    TextView destance;
    Bitmap profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);
        destance = (TextView) findViewById(R.id.LocationDestance);
        result=(RecyclerView)findViewById(R.id.ReviewRecicleView);
        LinearLayoutManager layoutManager = new  LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        result.setHasFixedSize(true);
        result.setLayoutManager(layoutManager);
        profileReviewListitems=new ArrayList<>();
        profile= BitmapFactory.decodeResource(getResources(),R.drawable.doctor);
        for (int i=0;i<=100;i++){

            ProfileReviewListitem profileReviewListitem=new ProfileReviewListitem(profile,"ALi Motie","25/4/2017",4,"adsdsdsdsdsdsdsdsdsdsdsdsdsdsdsasaddsadsadasdsaadsdsadsadsasasasasasasasasa");

            profileReviewListitems.add(profileReviewListitem);
        }
        adapter=new ProfileReviewAdaptor(profileReviewListitems,getApplicationContext());
        result.setAdapter(adapter);

    }

    public void DoctorProfileLocation(View view) {
        String uri = String.format("https://www.google.com/maps/dir/?api=1" + "&destination=" + "30.0329" + "," + "31.4100");
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);

    }

    public void DoctorProfileCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "01001289970"));
        startActivity(intent);



    }
    public void BookAppointment(View view){
        Intent intent=new Intent(getApplicationContext(),BookDoctor.class);
        startActivity(intent);
    }


}
