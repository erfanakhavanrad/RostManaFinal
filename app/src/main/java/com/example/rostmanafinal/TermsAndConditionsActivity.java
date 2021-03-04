package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.checkbox.MaterialCheckBox;

public class TermsAndConditionsActivity extends AppCompatActivity {
    WebView webView;
    CheckBox materialCheckBox;
    Button btnAgree;
    UserManagerSharedPrefs userManagerSharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);
        webView = findViewById(R.id.webView);
        materialCheckBox = findViewById(R.id.materialCheckBox);
        btnAgree = findViewById(R.id.btnAgree);
        userManagerSharedPrefs = new UserManagerSharedPrefs(this);


        WebSettings wbset = webView.getSettings();
        wbset.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String url = "http://rostmana.com/";

//        System.out.println(getdeviceid());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        materialCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (materialCheckBox.isChecked()) {
                    btnAgree.setEnabled(true);
                    btnAgree.setBackgroundColor(Color.parseColor("#26a653"));
                    btnAgree.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(TermsAndConditionsActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                            userManagerSharedPrefs.saveAgree(true);

                            Intent intent = new Intent(TermsAndConditionsActivity.this, LoginRegisterActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                } else {
                    btnAgree.setEnabled(false);
                    btnAgree.setBackgroundColor(Color.parseColor("#E0FFEB"));

                }
            }
        });


    }
}