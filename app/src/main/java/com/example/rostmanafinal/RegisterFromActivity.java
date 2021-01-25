package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.ModelRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterFromActivity extends AppCompatActivity {
    EditText registerPhoneNumber, registerPassword, registerConfirmPassword;
    Button btnRegister;
    String one, two, three;
RetrofitApiService retrofitApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_from);
        registerPhoneNumber = findViewById(R.id.registerPhoneNumber);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmPassword = findViewById(R.id.registerConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.88.134:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
retrofitApiService = retrofit.create(RetrofitApiService.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(RegisterFromActivity.this, "clicked", Toast.LENGTH_SHORT).show();
createPost();
//                Toast.makeText(RegisterFromActivity.this, registerPhoneNumber.getText().toString()+
//                        registerPassword.getText().toString()+
//                        registerConfirmPassword.getText().toString(), Toast.LENGTH_SHORT).show();


            }
        });
    }
    private void createPost(){
//        ModelRegister modelRegister = new ModelRegister("09353368421", "123456", "123456");
        Call<ModelRegister> call = retrofitApiService.postRegisterPage("09125471362", "123456", "123456");
        call.enqueue(new Callback<ModelRegister>() {
            @Override
            public void onResponse(Call<ModelRegister> call, Response<ModelRegister> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(RegisterFromActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegisterFromActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                    return;
                }
                ModelRegister modelRegister1 = response.body();
                Toast.makeText(RegisterFromActivity.this, "" + modelRegister1.getToken(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ModelRegister> call, Throwable t) {
                Toast.makeText(RegisterFromActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





}