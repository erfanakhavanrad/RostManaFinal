package com.example.rostmanafinal.Interfaces;

import com.example.rostmanafinal.Pojo.GetHello;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitApiService {


    @GET("hello")
    Call<GetHello> getHellovalue();

    @POST("goodbye")
    Call<GetHello> postGoodbyeValue();
}
