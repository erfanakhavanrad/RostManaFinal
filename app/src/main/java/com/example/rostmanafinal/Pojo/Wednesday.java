
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wednesday {

    @SerializedName("wwatering")
    @Expose
    private Integer wwatering;
    @SerializedName("wfan")
    @Expose
    private Integer wfan;
    @SerializedName("welement")
    @Expose
    private Integer welement;
    @SerializedName("wlight")
    @Expose
    private Integer wlight;
    @SerializedName("sfogger")
    @Expose
    private Integer sfogger;

    public Integer getWwatering() {
        return wwatering;
    }

    public void setWwatering(Integer wwatering) {
        this.wwatering = wwatering;
    }

    public Integer getWfan() {
        return wfan;
    }

    public void setWfan(Integer wfan) {
        this.wfan = wfan;
    }

    public Integer getWelement() {
        return welement;
    }

    public void setWelement(Integer welement) {
        this.welement = welement;
    }

    public Integer getWlight() {
        return wlight;
    }

    public void setWlight(Integer wlight) {
        this.wlight = wlight;
    }

    public Integer getSfogger() {
        return sfogger;
    }

    public void setSfogger(Integer sfogger) {
        this.sfogger = sfogger;
    }

}
