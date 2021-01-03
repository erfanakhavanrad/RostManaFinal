
package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("saturday")
    @Expose
    private Saturday saturday;
    @SerializedName("sunday")
    @Expose
    private Sunday sunday;
    @SerializedName("monday")
    @Expose
    private Monday monday;
    @SerializedName("thuesday")
    @Expose
    private Thuesday thuesday;
    @SerializedName("wednesday")
    @Expose
    private Wednesday wednesday;
    @SerializedName("thursday")
    @Expose
    private Thursday thursday;
    @SerializedName("fridayday")
    @Expose
    private Fridayday fridayday;

    public Saturday getSaturday() {
        return saturday;
    }

    public void setSaturday(Saturday saturday) {
        this.saturday = saturday;
    }

    public Sunday getSunday() {
        return sunday;
    }

    public void setSunday(Sunday sunday) {
        this.sunday = sunday;
    }

    public Monday getMonday() {
        return monday;
    }

    public void setMonday(Monday monday) {
        this.monday = monday;
    }

    public Thuesday getThuesday() {
        return thuesday;
    }

    public void setThuesday(Thuesday thuesday) {
        this.thuesday = thuesday;
    }

    public Wednesday getWednesday() {
        return wednesday;
    }

    public void setWednesday(Wednesday wednesday) {
        this.wednesday = wednesday;
    }

    public Thursday getThursday() {
        return thursday;
    }

    public void setThursday(Thursday thursday) {
        this.thursday = thursday;
    }

    public Fridayday getFridayday() {
        return fridayday;
    }

    public void setFridayday(Fridayday fridayday) {
        this.fridayday = fridayday;
    }

}
