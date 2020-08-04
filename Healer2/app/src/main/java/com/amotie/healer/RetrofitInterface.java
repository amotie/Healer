package com.amotie.healer;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("register")
    Call<String> executeSignUp(@Body HashMap<String,String> map);
    @POST("login")
    Call<String> executeLogin(@Body HashMap<String,String> map);

}
