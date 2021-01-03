
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Saturday {

    @SerializedName("swatering")
    @Expose
    private Integer swatering;
    @SerializedName("sfan")
    @Expose
    private Integer sfan;
    @SerializedName("selement")
    @Expose
    private Integer selement;
    @SerializedName("slight")
    @Expose
    private Integer slight;
    @SerializedName("sfogger")
    @Expose
    private Integer sfogger;

    public Integer getSwatering() {
        return swatering;
    }

    public void setSwatering(Integer swatering) {
        this.swatering = swatering;
    }

    public Integer getSfan() {
        return sfan;
    }

    public void setSfan(Integer sfan) {
        this.sfan = sfan;
    }

    public Integer getSelement() {
        return selement;
    }

    public void setSelement(Integer selement) {
        this.selement = selement;
    }

    public Integer getSlight() {
        return slight;
    }

    public void setSlight(Integer slight) {
        this.slight = slight;
    }

    public Integer getSfogger() {
        return sfogger;
    }

    public void setSfogger(Integer sfogger) {
        this.sfogger = sfogger;
    }

}
