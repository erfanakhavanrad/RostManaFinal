package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.BoringLayout;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
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
    UserManagerSharedPrefs userManagerSharedPrefs;
    String token;
    ConstraintLayout constraintProgress;
    Boolean number = true;

    private int duration = Toast.LENGTH_SHORT;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_from);
        constraintProgress = findViewById(R.id.constraintProgress);
        registerPhoneNumber = findViewById(R.id.registerPhoneNumber);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmPassword = findViewById(R.id.registerConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        userManagerSharedPrefs = new UserManagerSharedPrefs(this);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.88.134:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(RegisterFromActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                if (registerPhoneNumber.length() !=11 ) {
showMSG("difference");
                        return;
                }
                if(registerPassword!=registerConfirmPassword || registerPassword.length()<=6) {
                    Toast.makeText(RegisterFromActivity.this, "must be longer", Toast.LENGTH_SHORT).show();
                    return;
                }

//                if (registerPassword.getText().toString().equals(registerConfirmPassword.getText().toString())) {
//                    Toast.makeText(RegisterFromActivity.this, "the same", Toast.LENGTH_SHORT).show();
//                } else if (registerPassword.length() < 7 || registerConfirmPassword.length() < 7) {
//                    Toast.makeText(RegisterFromActivity.this, "password too short", Toast.LENGTH_SHORT).show();
//                } else {
//                    registerConfirmPassword.setError("doesn't match");
//                }


                /**number = false;
                 showLoading();
                 createPost(); */
//                Toast.makeText(RegisterFromActivity.this, registerPhoneNumber.getText().toString()+
//                        registerPassword.getText().toString()+
//                        registerConfirmPassword.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void showLoading() {

        if (number) {
            constraintProgress.setVisibility(View.GONE);

        } else {
            constraintProgress.setVisibility(View.VISIBLE);
        }
    }

    private void createPost() {
//        ModelRegister modelRegister = new ModelRegister("09353368421", "123456", "123456");
        Call<ModelRegister> call = retrofitApiService.postRegisterPage("09312653165", "123456", "123456");
        call.enqueue(new Callback<ModelRegister>() {
            @Override
            public void onResponse(Call<ModelRegister> call, Response<ModelRegister> response) {
                if (!response.isSuccessful()) {
                    ModelRegister modelRegister1 = response.body();
                    Toast.makeText(RegisterFromActivity.this, response.message(), Toast.LENGTH_SHORT).show();
//                    userManagerSharedPrefs.saveUserInformation("null", "null", response.body().getToken());
//                    token = modelRegister1.getToken();
//                  userManagerSharedPrefs.saveUserInformation("name", "lname", token);
//                    Intent i = new Intent(RegisterFromActivity.this, MainActivity.class);
//                    startActivity(i);
//                    finish();
                    return;
                } else {
                    Toast.makeText(RegisterFromActivity.this, "there was an error", Toast.LENGTH_SHORT).show();
                }

//                Toast.makeText(RegisterFromActivity.this, "" + modelRegister1.getToken(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ModelRegister> call, Throwable t) {
                Toast.makeText(RegisterFromActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                number = true;
                showLoading();
            }
        });
    }
    public void showMSG(String message){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_exit, cardView);
        TextView text = layout.findViewById(R.id.text);
        text.setText(message);
        Toast toast = new Toast(RegisterFromActivity.this);
        toast.setGravity(Gravity.BOTTOM, 0, 165);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();
    }


}