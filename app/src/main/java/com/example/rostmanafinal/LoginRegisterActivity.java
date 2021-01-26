package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
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
    Button btnEnter, btnGuest, btnRegister;
    TextInputEditText edtUsername, edtPassword;
    UserManagerSharedPrefs userManagerSharedPrefs;
    String token, url = "http://192.168.88.134:8000/api/";
    SharedPreferences sharedPreferences;
    RetrofitApiService request;
    private String TAG;
    Users users;
    Boolean number = true;
    boolean doubleBackToExitPressedOnce = false;
    ConstraintLayout constraintProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
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
        btnGuest = findViewById(R.id.btnGuest);
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginRegisterActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });


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
                number = false;
                showLoading();
                Call<Users> call = request.getUserPostToken(user, pass);
                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
//                        Toast.makeText(LoginRegisterActivity.this, "token" + response, Toast.LENGTH_SHORT).show();

                        Users users = response.body();
                        Log.e("keshav", "loginResponse 1 --> " + users);
                        if (users != null) {
//                           Log.e("keshav", "getUserId          -->  " + users.getAccess_token());
                            Toast.makeText(LoginRegisterActivity.this, "" + users.getAccess_token(), Toast.LENGTH_SHORT).show();
//                           String responseCode = users.getResponseCode();
//                           Log.e("keshav", "getResponseCode  -->  " + users.getResponseCode());
//                           Log.e("keshav", "getResponseMessage  -->  " + users.getResponseMessage());
//                           if (responseCode != null && responseCode.equals("404")) {
//                               Toast.makeText(MainActivity.this, "Invalid Login Details \n Please try again", Toast.LENGTH_SHORT).show();
//                           } else {
//                               Toast.makeText(MainActivity.this, "Welcome " + loginResponse.getFirstName(), Toast.LENGTH_SHORT).show();
//                           }
//                          String token =   users.getAccess_token();

                            token = users.getAccess_token();
                            Log.d(TAG, "onResponse: " + token);
                            userManagerSharedPrefs.saveUserInformation(edtUsername.getText().toString(),
                                    edtPassword.getText().toString(),
                                    token);

                            Intent i = new Intent(LoginRegisterActivity.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        }

                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        Toast.makeText(LoginRegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        number = true;
                        showLoading();
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
        Toast toast = Toast.makeText(LoginRegisterActivity.this, Html.fromHtml("<font color='#26a653' ><b>" + "برای خروج دوباره بازگشت را بزنید" + "</b></font>"), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.show();


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void showLoading() {

        if (number) {
            constraintProgress.setVisibility(View.GONE);

        } else {
            constraintProgress.setVisibility(View.VISIBLE);
        }
    }


}