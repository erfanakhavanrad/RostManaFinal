package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.SerializedName;

public class GetHello {
    @SerializedName("a")
    private String receivehello;

    public String getReceivehello() {
        return receivehello;
    }

    public void setReceivehello(String receivehello) {
        this.receivehello = receivehello;
    }

    public GetHello(String receivehello) {
        this.receivehello = receivehello;
    }
}
