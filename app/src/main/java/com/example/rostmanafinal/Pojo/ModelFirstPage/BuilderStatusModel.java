
package com.example.rostmanafinal.Pojo.ModelFirstPage;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuilderStatusModel implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("temp")
    @Expose
    private Integer temp;
    @SerializedName("light")
    @Expose
    private Integer light;
    @SerializedName("Element")
    @Expose
    private Integer element;
    @SerializedName("light_status")
    @Expose
    private Integer lightStatus;
    @SerializedName("humidity_soil")
    @Expose
    private Integer humiditySoil;
    @SerializedName("humidity_air")
    @Expose
    private Integer humidityAir;
    @SerializedName("water_level")
    @Expose
    private Integer waterLevel;
    @SerializedName("pump_w")
    @Expose
    private Integer pumpW;
    @SerializedName("fan_status")
    @Expose
    private Integer fanStatus;
    @SerializedName("fogger_status")
    @Expose
    private Integer foggerStatus;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    public final static Creator<BuilderStatusModel> CREATOR = new Creator<BuilderStatusModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BuilderStatusModel createFromParcel(Parcel in) {
            return new BuilderStatusModel(in);
        }

        public BuilderStatusModel[] newArray(int size) {
            return (new BuilderStatusModel[size]);
        }

    };
    private final static long serialVersionUID = -7708470206929477685L;

    protected BuilderStatusModel(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.temp = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.light = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.element = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lightStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.humiditySoil = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.humidityAir = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.waterLevel = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pumpW = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fanStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.foggerStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BuilderStatusModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }

    public Integer getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(Integer lightStatus) {
        this.lightStatus = lightStatus;
    }

    public Integer getHumiditySoil() {
        return humiditySoil;
    }

    public void setHumiditySoil(Integer humiditySoil) {
        this.humiditySoil = humiditySoil;
    }

    public Integer getHumidityAir() {
        return humidityAir;
    }

    public void setHumidityAir(Integer humidityAir) {
        this.humidityAir = humidityAir;
    }

    public Integer getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Integer waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Integer getPumpW() {
        return pumpW;
    }

    public void setPumpW(Integer pumpW) {
        this.pumpW = pumpW;
    }

    public Integer getFanStatus() {
        return fanStatus;
    }

    public void setFanStatus(Integer fanStatus) {
        this.fanStatus = fanStatus;
    }

    public Integer getFoggerStatus() {
        return foggerStatus;
    }

    public void setFoggerStatus(Integer foggerStatus) {
        this.foggerStatus = foggerStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(temp);
        dest.writeValue(light);
        dest.writeValue(element);
        dest.writeValue(lightStatus);
        dest.writeValue(humiditySoil);
        dest.writeValue(humidityAir);
        dest.writeValue(waterLevel);
        dest.writeValue(pumpW);
        dest.writeValue(fanStatus);
        dest.writeValue(foggerStatus);
        dest.writeValue(createdAt);
    }

    public int describeContents() {
        return 0;
    }

}
