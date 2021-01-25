package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.SerializedName;

public class Users {
    @SerializedName("phonenumber")
    private String phonenumber;
    @SerializedName("password")
    private String password;
    @SerializedName("expires_at")
    private String expires_at;
    @SerializedName("access_token")
    private String access_token;

    public Users(String phonenumber, String password, String expires_at, String access_token) {
        this.phonenumber = phonenumber;
        this.password = password;
        this.expires_at = expires_at;
        this.access_token = access_token;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }



    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
