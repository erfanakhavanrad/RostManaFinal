
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Monday {

    @SerializedName("mwatering")
    @Expose
    private Integer mwatering;
    @SerializedName("mfan")
    @Expose
    private Integer mfan;
    @SerializedName("melement")
    @Expose
    private Integer melement;
    @SerializedName("mlight")
    @Expose
    private Integer mlight;
    @SerializedName("sfogger")
    @Expose
    private Integer sfogger;

    public Integer getMwatering() {
        return mwatering;
    }

    public void setMwatering(Integer mwatering) {
        this.mwatering = mwatering;
    }

    public Integer getMfan() {
        return mfan;
    }

    public void setMfan(Integer mfan) {
        this.mfan = mfan;
    }

    public Integer getMelement() {
        return melement;
    }

    public void setMelement(Integer melement) {
        this.melement = melement;
    }

    public Integer getMlight() {
        return mlight;
    }

    public void setMlight(Integer mlight) {
        this.mlight = mlight;
    }

    public Integer getSfogger() {
        return sfogger;
    }

    public void setSfogger(Integer sfogger) {
        this.sfogger = sfogger;
    }

}
