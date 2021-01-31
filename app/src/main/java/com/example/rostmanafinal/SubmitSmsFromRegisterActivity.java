package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.ModelRegister;
import com.example.rostmanafinal.Pojo.User;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;

import java.security.KeyStore;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitSmsFromRegisterActivity extends AppCompatActivity {
    EditText serialEnteredActivity;
    String serialEnteredValue;
    Button btnConfirmActivity;
    //    UserManagerSharedPrefs userManagerSharedPrefs;
    RetrofitApiService request;
    String url = "http://192.168.88.134:8000/api/";
    RetrofitApiService retrofitApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_sms_from_register);
        UserManagerSharedPrefs userManagerSharedPrefs = new UserManagerSharedPrefs(this);
        serialEnteredActivity = findViewById(R.id.serialEnteredActivity);
        btnConfirmActivity = findViewById(R.id.btnConfirmActivity);
        String token = userManagerSharedPrefs.getToken();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.88.134:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);

        btnConfirmActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                userManagerSharedPrefs = new UserManagerSharedPrefs(SubmitSmsFromRegisterActivity.this);
//                Toast.makeText(SubmitSmsFromRegisterActivity.this, "" + userManagerSharedPrefs.getToken(), Toast.LENGTH_SHORT).show();
                createPost();

            }
        });


    }


    private void createPost() {
//        Call<ModelRegister> call = retrofitApiService.postRegisterPage(
        Call<ModelRegister> call = retrofitApiService.post6DigitsCode(111111);
        call.enqueue(new Callback<ModelRegister>() {
            @Override
            public void onResponse(Call<ModelRegister> call, Response<ModelRegister> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SubmitSmsFromRegisterActivity.this, "success" + response.body(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SubmitSmsFromRegisterActivity.this, "error in on response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelRegister> call, Throwable t) {
                Toast.makeText(SubmitSmsFromRegisterActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}