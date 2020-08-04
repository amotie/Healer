package com.amotie.healer;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpConnection extends AsyncTask<String,Void,String> {
    private WeakReference<SignUp> signUpWeakReference;
    private Retrofit retrofit;
    String ret;
    private RetrofitInterface retrofitInterface;
    public SignUpConnection(SignUp signUp) {
        signUpWeakReference = new WeakReference<SignUp>(signUp);
    }

    @Override
    protected void onPreExecute() {
        SignUp signUp = signUpWeakReference.get();
        if (signUp == null || signUp.isFinishing()) {
            return;
        }
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.2:27017/patient/").addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface=retrofit.create(RetrofitInterface.class);
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String name=strings[0];
        String phone=strings[1];
        String email=strings[2];
        String gender=strings[3];
        String age=strings[4];
        String password=strings[5];
        HashMap<String,String> map =new HashMap<>();
        map.put("name",name);
        map.put("phone",phone);
        map.put("email",email);
        map.put("gender",gender);
        map.put("age",age);
        map.put("password",password);
        Call<String> call = retrofitInterface.executeSignUp(map);


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
    protected void onPostExecute(String s)
    {
        SignUp activity=signUpWeakReference.get();
                Intent intent = new Intent(activity, Login.class);
               activity.startActivity(intent);
        if(activity==null||activity.isFinishing()) {
            return;
        }
        super.onPostExecute(s);
    }
}