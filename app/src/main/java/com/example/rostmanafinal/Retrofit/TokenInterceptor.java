package com.example.rostmanafinal.Retrofit;

import com.example.rostmanafinal.UserManagerSharedPrefs;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    private String authToken;

//    public TokenInterceptor(ُString authToken) {
//        this.authToken = authToken;
//    }


    public TokenInterceptor(String authToken) {
        this.authToken = authToken;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        //rewrite the request to add bearer token
//        String yourtokenvalue = "3222";
        Request newRequest = chain.request().newBuilder()
                .header("Authorization", "Bearer " + authToken)
                .build();
        return chain.proceed(newRequest);
    }
}
