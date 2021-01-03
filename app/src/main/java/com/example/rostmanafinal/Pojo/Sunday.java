
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sunday {

    @SerializedName("suwatering")
    @Expose
    private Integer suwatering;
    @SerializedName("sufan")
    @Expose
    private Integer sufan;
    @SerializedName("suelement")
    @Expose
    private Integer suelement;
    @SerializedName("sulight")
    @Expose
    private Integer sulight;
    @SerializedName("sfogger")
    @Expose
    private Integer sfogger;

    public Integer getSuwatering() {
        return suwatering;
    }

    public void setSuwatering(Integer suwatering) {
        this.suwatering = suwatering;
    }

    public Integer getSufan() {
        return sufan;
    }

    public void setSufan(Integer sufan) {
        this.sufan = sufan;
    }

    public Integer getSuelement() {
        return suelement;
    }

    public void setSuelement(Integer suelement) {
        this.suelement = suelement;
    }

    public Integer getSulight() {
        return sulight;
    }

    public void setSulight(Integer sulight) {
        this.sulight = sulight;
    }

    public Integer getSfogger() {
        return sfogger;
    }

    public void setSfogger(Integer sfogger) {
        this.sfogger = sfogger;
    }

}
