package com.example.rostmanafinal;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        sharedPreferences = context.getSharedPreferences("user_information", Context.MODE_PRIVATE);

    }

    public void saveUserInformation(String fullName, String email, String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("full_name", fullName);
        editor.putString("email", email);
        editor.putString("token", token);
        editor.apply();
    }

    public String getFullName() {
        return sharedPreferences.getString("full_name", "");
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }

    public String getToken() {
        return sharedPreferences.getString("token", "");
    }

}
