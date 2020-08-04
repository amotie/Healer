package com.amotie.healer;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Window;

import com.amotie.healer.Login;
import com.amotie.healer.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginConnection extends AsyncTask<String,Void,Void> {
   private WeakReference<Login> loginWeakReference;
    private Retrofit retrofit;
    String ret;
    private RetrofitInterface retrofitInterface;
   public LoginConnection(Login login){
       loginWeakReference=new WeakReference<Login>(login);
   }





    @Override
    protected void onPreExecute() {
       Login login=loginWeakReference.get();
       if (login == null || login.isFinishing()){
           return;
       }
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.2:27017/patient/").addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface=retrofit.create(RetrofitInterface.class);
//         dialog=new ProgressDialog(login.getApplicationContext());
//        dialog.show();
//        dialog.setContentView(R.layout.lodding);
//        Window window=dialog.getWindow();
//        window.setBackgroundDrawableResource(R.color.colorBackground);
//        window.setLayout(250, 250);
//        dialog.setCancelable(false);
//        super.onPreExecute();
    }



    @Override
    protected Void doInBackground(String... strings) {


        String email=strings[0];

        String password=strings[1];
        HashMap<String,String> map =new HashMap<>();

        map.put("email",email);

        map.put("password",password);
        Call<String> call = retrofitInterface.executeLogin(map);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                ret=response.body();
                Log.d("adsdsdsdsa",ret);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                ret=t.getMessage().toString();
                Log.d("Errrrrror",ret);
            }
        });



        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        Login activity=loginWeakReference.get();
//            dialog.dismiss();

        if(activity==null||activity.isFinishing()){
            return;
        }
        super.onPostExecute(aVoid);
    }
}
