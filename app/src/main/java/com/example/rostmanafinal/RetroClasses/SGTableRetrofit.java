package com.example.rostmanafinal.RetroClasses;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SGTableRetrofit {

    public static final String API_BASE_URL =
            "https://api.github.com/";

    // ۲
    private static OkHttpClient httpClient =
            new OkHttpClient.Builder().build();

    // ۳
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    // ۴
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }


}
