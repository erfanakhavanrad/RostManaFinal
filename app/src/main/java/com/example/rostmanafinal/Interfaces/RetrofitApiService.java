package com.example.rostmanafinal.Interfaces;

import com.example.rostmanafinal.Pojo.GetHello;
import com.example.rostmanafinal.Pojo.Users;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitApiService {

    @GET("hello")
    Call<GetHello> getHellovalue();

    @POST("goodbye")
    Call<GetHello> postGoodbyeValue();

    @FormUrlEncoded
    @POST("login")
    Call<Users> getUserPostToken(@Field("phonenumber") String phoneNumber,
                                 @Field("password") String password);

//    @FormUrlEncoded
//    @POST(URL) Call<ResponseBody> getdata(@Field("jdata") String jdata);
}
