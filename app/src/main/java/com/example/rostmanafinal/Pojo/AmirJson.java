
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AmirJson {

    @SerializedName("res")
    @Expose
    private Res res;

    public Res getRes() {
        return res;
    }

    public void setRes(Res res) {
        this.res = res;
    }

}
