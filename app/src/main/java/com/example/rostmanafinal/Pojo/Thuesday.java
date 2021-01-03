
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thuesday {

    @SerializedName("twatering")
    @Expose
    private Integer twatering;
    @SerializedName("tfan")
    @Expose
    private Integer tfan;
    @SerializedName("telement")
    @Expose
    private Integer telement;
    @SerializedName("tlight")
    @Expose
    private Integer tlight;
    @SerializedName("sfogger")
    @Expose
    private Integer sfogger;

    public Integer getTwatering() {
        return twatering;
    }

    public void setTwatering(Integer twatering) {
        this.twatering = twatering;
    }

    public Integer getTfan() {
        return tfan;
    }

    public void setTfan(Integer tfan) {
        this.tfan = tfan;
    }

    public Integer getTelement() {
        return telement;
    }

    public void setTelement(Integer telement) {
        this.telement = telement;
    }

    public Integer getTlight() {
        return tlight;
    }

    public void setTlight(Integer tlight) {
        this.tlight = tlight;
    }

    public Integer getSfogger() {
        return sfogger;
    }

    public void setSfogger(Integer sfogger) {
        this.sfogger = sfogger;
    }

}
