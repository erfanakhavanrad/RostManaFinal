package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.ModelSMS.User;
import com.example.rostmanafinal.Pojo.ModelSMS.VerifyModel;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;

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
    String url = "http://rostmana.com/api/";
    //    RetrofitApiService retrofitApiService;
    TextView txtSmsTest;
    ConstraintLayout constraintLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_sms_from_register);
        UserManagerSharedPrefs userManagerSharedPrefs = new UserManagerSharedPrefs(this);
        serialEnteredActivity = findViewById(R.id.serialEnteredActivity);
        btnConfirmActivity = findViewById(R.id.btnConfirmActivity);
        String token = userManagerSharedPrefs.getToken();
        txtSmsTest = findViewById(R.id.txtSmsTest);
        constraintLoading = findViewById(R.id.constraintLoading);
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiYjEyMTk1ODFiNDEzMTBmOTQyYzFhYjllZTY3ZDE4ZTM0ZjMyMWQ2ZjhiZjM0NjcxNzBmNWI4NmI1ZjQ1ODkzMjU1ODQ0N2Q0MWUxNmM2NjciLCJpYXQiOjE2MTIwODk3OTIsIm5iZiI6MTYxMjA4OTc5MiwiZXhwIjoxNjQzNjI1NzkyLCJzdWIiOiIxNDUiLCJzY29wZXMiOltdfQ.MvtTLEhl4cNARTvyj1E6h7gdFupNxhP3WLNcGJo1FcFQa9Ab_mNf5dOB4CE_6_sxB0SUuTX744SHcMzK3xEWH5lqX5j1nPjRS0-buGwgkbPzTdFfjnYYL4O0AcbA6bV9GBtTiIM9s1nObZmzWPLBIehH1F2YTH_n3eKuYGd6qtgB98ddUXHPCiLu_4MvkKN3VYnr2OPgqvN2T2LxwZvDS1si2pVHxthcJ1A4ZOAXG8XHBIP39j8BUvgTVlJnW3oeNCXp6l05d1kHXvR8IuqrTZh1x2rZgDwU3Sz9lq8DUKV2JRnLR9CTgWgoBvM8Xdt6hPT7hGwl9eC3_XG4CwX-lcNMsUyPsFyj1-c97hGma9I4GPd_Lu56NnA3_il7q7Tc8DCzu5xGyM_JNGYmfthb2GB_m7YV2tUDTnrf4JTeBStDwaCgnNiaKZLRyPW3EVjVysbEqQlrfgmlNXYv_OQ6fz23npuE49DdgncczS21k6ll8fMfyCYSigpREhdfLdUHoYeaxN4uzRbzd4bItIujKvblqYoN05WGxDkTrv2dMek_DMclSEh1oyA4SwOVpJkcdISB5_PIHiSmjC4sAJ1zKzpuAtmKDtduJLPEhE1IV5QlaTYsJe79mhjBqwHIkRG0L0sM1Uq37hnY9dqpU68efXUNOI5ClovyycfP3zfYqxY";

        TokenInterceptor interceptor = new TokenInterceptor(token);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        request = retrofit.create(RetrofitApiService.class);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.88.134:8000/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        retrofitApiService = retrofit.create(RetrofitApiService.class);

        btnConfirmActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                userManagerSharedPrefs = new UserManagerSharedPrefs(SubmitSmsFromRegisterActivity.this);
//                Toast.makeText(SubmitSmsFromRegisterActivity.this, "" + userManagerSharedPrefs.getToken(), Toast.LENGTH_SHORT).show();
                constraintLoading.setVisibility(View.VISIBLE);
                createPost();

            }
        });


    }


    private void createPost() {
//        Call<ModelRegister> call = retrofitApiService.postRegisterPage(
        Call<VerifyModel> call = request.post6DigitsCode(111111);
        call.enqueue(new Callback<VerifyModel>() {
            @Override
            public void onResponse(Call<VerifyModel> call, Response<VerifyModel> response) {
                if (response.isSuccessful()) {

//                    txtSmsTest.setText(response.body().getUser().getEmailVerifiedAt());
                    constraintLoading.setVisibility(View.GONE);
                    Intent i = new Intent(SubmitSmsFromRegisterActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(SubmitSmsFromRegisterActivity.this, "onRespnse" + response.message(), Toast.LENGTH_SHORT).show();
                    constraintLoading.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<VerifyModel> call, Throwable t) {
                txtSmsTest.setText(t.getMessage());
                constraintLoading.setVisibility(View.GONE);
                Toast.makeText(SubmitSmsFromRegisterActivity.this, "on error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}