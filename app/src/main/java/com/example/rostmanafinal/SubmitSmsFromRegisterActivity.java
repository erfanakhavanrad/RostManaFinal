package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubmitSmsFromRegisterActivity extends AppCompatActivity {
EditText serialEnteredActivity;
String serialEnteredValue;
Button btnConfirmActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_sms_from_register);
        serialEnteredActivity = findViewById(R.id.serialEnteredActivity);
        btnConfirmActivity = findViewById(R.id.btnConfirmActivity);
        btnConfirmActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serialEnteredValue = serialEnteredActivity.getText().toString();
                Toast.makeText(SubmitSmsFromRegisterActivity.this, "" + serialEnteredValue, Toast.LENGTH_SHORT).show();

            }
        });
    }
}