package com.example.rostmanafinal.Interfaces;

import com.example.rostmanafinal.Pojo.GetHello;
import com.example.rostmanafinal.Pojo.ModelEditProfile;
import com.example.rostmanafinal.Pojo.ModelRegister;
import com.example.rostmanafinal.Pojo.Users;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitApiService {
// GET test
    @GET("hello")
    Call<GetHello> getHellovalue();
// POST test
    @POST("goodbye")
    Call<GetHello> postGoodbyeValue();



// This is for the login page
    @FormUrlEncoded
    @POST("login")
    Call<Users> getUserPostToken(@Field("phonenumber") String phoneNumber,
                                 @Field("password") String password);

// This is for the EditProfile page
    @FormUrlEncoded
    @POST("Updatauser")
    Call<ModelEditProfile> PostEditProfileAPIService(@Header("Dynamic-Header") String header,
                                                     @Field("sex") Boolean sex,
                                                     @Field("profileImage") String profileImage,
                                                     @Field("name") String name,
                                                     @Field("lastName") String lastName,
                                                     @Field("phonenumber") String phonenumber,
                                                     @Field("address") String address,
                                                     @Field("birth") String birth
    );

//This is for register page
    @FormUrlEncoded
    @POST("register")
    Call<ModelRegister> postRegisterPage (@Field("phonenumber") String phonenumber,
                                          @Field("password") String password,
                                          @Field("c_password") String c_password
                                          );
// This is for logged in user to receive data
//    @FormUrlEncoded
//    @POST("loggedinuser")
//    Call<>



//    @FormUrlEncoded
//    @POST(URL) Call<ResponseBody> getdata(@Field("jdata") String jdata);
}
