package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFromActivity extends AppCompatActivity {
    EditText registerPhoneNumber, registerPassword, registerConfirmPassword;
    Button btnRegister;
    String one, two, three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_from);
        registerPhoneNumber = findViewById(R.id.registerPhoneNumber);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmPassword = findViewById(R.id.registerConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(RegisterFromActivity.this, registerPhoneNumber.getText().toString()+
//                        registerPassword.getText().toString()+
//                        registerConfirmPassword.getText().toString(), Toast.LENGTH_SHORT).show();
                

            }
        });


    }
}