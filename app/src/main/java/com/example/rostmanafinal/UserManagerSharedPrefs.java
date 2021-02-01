package com.example.rostmanafinal;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManagerSharedPrefs {
    private SharedPreferences sharedPreferences;

    public UserManagerSharedPrefs(Context context) {
        sharedPreferences = context.getSharedPreferences("user_information", Context.MODE_PRIVATE);
    }

    public void saveUserInformation(String fullName, String email, String token, String verifiedAt) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("full_name", fullName);
        editor.putString("email", email);
        editor.putString("token", token);
        editor.putString("verifiedAt", verifiedAt);
        editor.apply();
    }


    public String getVerifiedAt() {
        return sharedPreferences.getString("verifiedAt", null);
    }

    public String getFullName() {
        return sharedPreferences.getString("full_name", null);
    }

    public String getEmail() {
        return sharedPreferences.getString("email", null);
    }

    public String getToken() {
        return sharedPreferences.getString("token", null);
    }

    public void clearAllInformation() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
