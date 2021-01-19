package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
    Button btnEnter, btnGuest;
    TextInputEditText edtUsername, edtPassword;
    UserManagerSharedPrefs userManagerSharedPrefs;
    String token, url = "http://192.168.88.134:8000/api/";
    SharedPreferences sharedPreferences;
    RetrofitApiService request;
    private String TAG;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
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
                            Log.d(TAG, "onResponse: "+ token);
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
                    }
                });


//                Call<Users> call = request.getUserPostToken(user, pass);
//                call.enqueue(new Callback<Users>() {
//                    @Override
//                    public void onResponse(Call<Users> call, Response<Users> response) {

//                        if (response.body().getDataResponse().equals("access_token")) {
//                            Toast.makeText(LoginRegisterActivity.this, "login success", Toast.LENGTH_SHORT).show();
//                        } else if (response.body().getDataResponse().equals("expires_at")) {
//                            Toast.makeText(LoginRegisterActivity.this, "", Toast.LENGTH_SHORT).show();
//                        } else if (response.body().getDataResponse().equals("WRONG")){
//                            Toast.makeText(LoginRegisterActivity.this, "wrong username or password", Toast.LENGTH_SHORT).show();
//                        }
//                        Toast.makeText(LoginRegisterActivity.this, "token" + response, Toast.LENGTH_SHORT).show();
//                    }


//                    @Override
//                    public void onFailure(Call<Users> call, Throwable t) {
//                        Toast.makeText(LoginRegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, t.getMessage());
//                    }
//                });
//
//



//userManagerSharedPrefs.saveUserInformation(token);.

            }

        });


    }

}