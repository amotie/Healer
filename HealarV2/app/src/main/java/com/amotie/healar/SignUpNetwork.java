package com.amotie.healar;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.amotie.healar.MainActivity;
import com.amotie.healar.SignUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

public class SignUpNetwork extends AsyncTask<String,Void,String> {
    private WeakReference<SignUp> signUpWeakReference;
    public SignUpNetwork(SignUp signUp){
        signUpWeakReference=new WeakReference<SignUp>(signUp);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected String doInBackground(String... strings) {
        String register_Uri="https://cloud.mongodb.com/api/atlas/v1.0/groups/5de0fc8cd5ec13d5943e5587/clusters/cluster0/patient/register";
        try{
            String username=strings[0];
            String email=strings[1];
            String phone=strings[2];
            String password=strings[3];
            String age=strings[4];
            String gender=strings[5];
            URL url=new URL(register_Uri);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(
                    new OutputStreamWriter(outputStream,"utf-8")
            );
            String post_data=
                     URLEncoder.encode("username","utf-8")+"="+URLEncoder.encode(username,"utf-8") +"&"
                    +URLEncoder.encode("email","utf-8")+"="+URLEncoder.encode(email,"utf-8")+"&"
                    +URLEncoder.encode("phone","utf-8")+"="+URLEncoder.encode(phone,"utf-8")+"&"
                    +URLEncoder.encode("password","utf-8")+"="+URLEncoder.encode(password,"utf-8")+"&"
                    +URLEncoder.encode("age","utf-8")+"="+URLEncoder.encode(age,"utf-8")+"&"
                    +URLEncoder.encode("gender","utf-8")+"="+URLEncoder.encode(gender,"utf-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line;
            while ((line=bufferedReader.readLine())!=null){
                result+=line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        SignUp activity=signUpWeakReference.get();
        System.out.println(s);
        if(s.equals("Welcome")){
            if(activity==null||activity.isFinishing()){
                return;
            }
            Intent intent=new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        }
        else{
            if(activity==null||activity.isFinishing()){
                return;
            }
            Toast.makeText(activity,s,Toast.LENGTH_SHORT).show();
        }
        System.out.println(s);
    }
}
