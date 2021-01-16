package com.example.rostmanafinal.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    GsonBuilder gsonBuilder = new GsonBuilder().setLenient();
    Gson gson = gsonBuilder.create();
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
