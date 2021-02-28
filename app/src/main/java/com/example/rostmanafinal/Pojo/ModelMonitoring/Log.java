
package com.example.rostmanafinal.Pojo.ModelMonitoring;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Log implements Serializable, Parcelable
{

    @SerializedName("temp")
    @Expose
    private String temp;
    @SerializedName("light")
    @Expose
    private String light;
    @SerializedName("humidity_soil")
    @Expose
    private String humiditySoil;
    @SerializedName("humidity_air")
    @Expose
    private String humidityAir;
    @SerializedName("water_level")
    @Expose
    private String waterLevel;
    @SerializedName("fan_status")
    @Expose
    private String fanStatus;
    @SerializedName("fogger_status")
    @Expose
    private String foggerStatus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    public final static Creator<Log> CREATOR = new Creator<Log>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Log createFromParcel(Parcel in) {
            return new Log(in);
        }

        public Log[] newArray(int size) {
            return (new Log[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2757941590127703492L;

    protected Log(Parcel in) {
        this.temp = ((String) in.readValue((String.class.getClassLoader())));
        this.light = ((String) in.readValue((String.class.getClassLoader())));
        this.humiditySoil = ((String) in.readValue((String.class.getClassLoader())));
        this.humidityAir = ((String) in.readValue((String.class.getClassLoader())));
        this.waterLevel = ((String) in.readValue((String.class.getClassLoader())));
        this.fanStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.foggerStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Log() {
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getHumiditySoil() {
        return humiditySoil;
    }

    public void setHumiditySoil(String humiditySoil) {
        this.humiditySoil = humiditySoil;
    }

    public String getHumidityAir() {
        return humidityAir;
    }

    public void setHumidityAir(String humidityAir) {
        this.humidityAir = humidityAir;
    }

    public String getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getFanStatus() {
        return fanStatus;
    }

    public void setFanStatus(String fanStatus) {
        this.fanStatus = fanStatus;
    }

    public String getFoggerStatus() {
        return foggerStatus;
    }

    public void setFoggerStatus(String foggerStatus) {
        this.foggerStatus = foggerStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temp);
        dest.writeValue(light);
        dest.writeValue(humiditySoil);
        dest.writeValue(humidityAir);
        dest.writeValue(waterLevel);
        dest.writeValue(fanStatus);
        dest.writeValue(foggerStatus);
        dest.writeValue(createdAt);
    }

    public int describeContents() {
        return  0;
    }

}
