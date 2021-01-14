package com.example.rostmanafinal.Retrofit;

import com.example.rostmanafinal.Interfaces.RetrofitApiService;

import okhttp3.Interceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.rostmanafinal.Retrofit.ApiConfig.BASE_URL;

public class ApiCore {

    private static ApiCore apiCore;

    private Retrofit retrofit;
    private RetrofitApiService retrofitApiService;

    private ApiCore() {
    }

    public static ApiCore instance(){
        if (apiCore == null) apiCore = new ApiCore();

        return apiCore;
    }

    public static RetrofitApiService retrofit(){
        return instance().retrofitApiService;
    }

    public void config(){

//        Interceptor interceptor;

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

retrofitApiService = retrofit.create(RetrofitApiService.class);


    }
}
