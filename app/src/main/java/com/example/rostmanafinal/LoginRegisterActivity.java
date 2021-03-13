package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rostmanafinal.Fragments.FirstFragment;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.Users;
import com.example.rostmanafinal.Retrofit.APIClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRegisterActivity extends AppCompatActivity {
    Button btnEnter, btnRegister;
    TextInputEditText edtUsername, edtPassword;
    UserManagerSharedPrefs userManagerSharedPrefs;
    String token, verifiedAt, url = "http://rostmana.com/api/";
    //    SharedPreferences sharedPreferences;
    RetrofitApiService request;
    private String TAG;
    Users users;
    Boolean number = true;
    private Context context;
    boolean doubleBackToExitPressedOnce = false;
    ConstraintLayout constraintProgress;
    private int duration = Toast.LENGTH_SHORT;
    TextView txtForgotPassword;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, cardView);
                TextView text = layout.findViewById(R.id.text);
                text.setText(R.string.custom_toast_message);
                Toast toast = new Toast(LoginRegisterActivity.this);
                toast.setGravity(Gravity.BOTTOM, 0, 40);
                toast.setDuration(duration);
                toast.setView(layout);
                toast.show();

            }
        });


        constraintProgress = findViewById(R.id.constraintProgress);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginRegisterActivity.this, RegisterFromActivity.class);
                startActivity(i);
//                finish();
            }
        });


        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        request = APIClient.getApiClient(url).create(RetrofitApiService.class);
        userManagerSharedPrefs = new UserManagerSharedPrefs(this);

        btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();
                if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(user)) {
                    Toast.makeText(LoginRegisterActivity.this, "لطفا تمام کادرها را پر کنید", Toast.LENGTH_SHORT).show();
                    return;
                }
//                else if (edtPassword.getText().toString() >)
                number = false;
//                showLoading();
                Call<Users> call = request.getUserPostToken(user, pass);
                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful()) {
                            Users users = response.body();
                            if (users != null) {
                                token = users.getAccess_token();
                                verifiedAt = users.getExpires_at();
                                Log.d(TAG, "onResponse: " + token);
                                userManagerSharedPrefs.saveUserInformation(edtUsername.getText().toString(),
                                        edtPassword.getText().toString(),
                                        token, verifiedAt);

                                Intent i = new Intent(LoginRegisterActivity.this, MainActivity.class);
                                startActivity(i);
                                finish();
                            } else if (response.code() == 404) {
                                Toast.makeText(LoginRegisterActivity.this, "not found", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(LoginRegisterActivity.this, "on response error", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        Toast.makeText(LoginRegisterActivity.this, "ابتدا باید ثبت نام کنید", Toast.LENGTH_SHORT).show();
                        Log.i(TAG, "onFailure: " + t.getMessage());
                        number = true;
//                        showLoading();
                    }
                });


            }

        });


    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "برای خروج دوباره بازگشت را بزنید", Toast.LENGTH_SHORT).show();
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_exit, cardView);
        TextView text = layout.findViewById(R.id.text);
        text.setText(R.string.exitApp);
        Toast toast = new Toast(LoginRegisterActivity.this);
        toast.setGravity(Gravity.BOTTOM, 0, 165);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
/*
    private void showLoading() {

        if (number) {
            constraintProgress.setVisibility(View.GONE);

        } else {
            constraintProgress.setVisibility(View.VISIBLE);
        }
    } */


}