
package com.example.rostmanafinal.Pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Res {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("info")
    @Expose
    private List<Info> info = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

}
