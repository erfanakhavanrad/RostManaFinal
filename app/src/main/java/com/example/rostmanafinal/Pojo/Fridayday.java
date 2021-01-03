
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fridayday {

    @SerializedName("fwatering")
    @Expose
    private Integer fwatering;
    @SerializedName("ffan")
    @Expose
    private Integer ffan;
    @SerializedName("felement")
    @Expose
    private Integer felement;
    @SerializedName("flight")
    @Expose
    private Integer flight;
    @SerializedName("sfogger")
    @Expose
    private Integer sfogger;

    public Integer getFwatering() {
        return fwatering;
    }

    public void setFwatering(Integer fwatering) {
        this.fwatering = fwatering;
    }

    public Integer getFfan() {
        return ffan;
    }

    public void setFfan(Integer ffan) {
        this.ffan = ffan;
    }

    public Integer getFelement() {
        return felement;
    }

    public void setFelement(Integer felement) {
        this.felement = felement;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getSfogger() {
        return sfogger;
    }

    public void setSfogger(Integer sfogger) {
        this.sfogger = sfogger;
    }

}
