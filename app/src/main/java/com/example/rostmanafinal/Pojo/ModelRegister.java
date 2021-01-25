package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.SerializedName;

public class ModelRegister {
    @SerializedName("phonenumber")
    private String phoneNumber;
    @SerializedName("password")
    private String password;

    public ModelRegister(String phoneNumber, String password, String c_password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.c_password = c_password;
    }

    @SerializedName("c_password")
    private String c_password;
    @SerializedName("expires_at")
    private String expires_at;
    @SerializedName("token")
    private String token;
    @SerializedName("code")
    private String code;


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getC_password() {
        return c_password;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public String getToken() {
        return token;
    }

    public String getCode() {
        return code;
    }
}
