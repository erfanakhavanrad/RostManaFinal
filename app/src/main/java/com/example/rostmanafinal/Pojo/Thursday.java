
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thursday {

    @SerializedName("thwatering")
    @Expose
    private Integer thwatering;
    @SerializedName("thfan")
    @Expose
    private Integer thfan;
    @SerializedName("thelement")
    @Expose
    private Integer thelement;
    @SerializedName("thlight")
    @Expose
    private Integer thlight;
    @SerializedName("sfogger")
    @Expose
    private Integer sfogger;

    public Integer getThwatering() {
        return thwatering;
    }

    public void setThwatering(Integer thwatering) {
        this.thwatering = thwatering;
    }

    public Integer getThfan() {
        return thfan;
    }

    public void setThfan(Integer thfan) {
        this.thfan = thfan;
    }

    public Integer getThelement() {
        return thelement;
    }

    public void setThelement(Integer thelement) {
        this.thelement = thelement;
    }

    public Integer getThlight() {
        return thlight;
    }

    public void setThlight(Integer thlight) {
        this.thlight = thlight;
    }

    public Integer getSfogger() {
        return sfogger;
    }

    public void setSfogger(Integer sfogger) {
        this.sfogger = sfogger;
    }

}
