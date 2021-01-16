package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginRegisterActivity extends AppCompatActivity {
    Button btnEnter;
    TextInputEditText edtUsername, edtPassword;
    UserManager userManager;
    String token;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        userManager = new UserManager(this);
//        sharedPreferences = getSharedPreferences("", MODE_PRIVATE);

        btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass = edtPassword.getText().toString();
                String user = edtUsername.getText().toString();


                if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(user)) {
                    Toast.makeText(LoginRegisterActivity.this, "لطفا تمام کادرها را پر کنید", Toast.LENGTH_SHORT).show();
                    return;
                }

                userManager.saveUserInformation(edtUsername.getText().toString(),
                        edtPassword.getText().toString(),
                        token);


                Intent i = new Intent(LoginRegisterActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }

        });

/*Start

     fullname.setText(usermanager.getfullname);

  **/

    }
}