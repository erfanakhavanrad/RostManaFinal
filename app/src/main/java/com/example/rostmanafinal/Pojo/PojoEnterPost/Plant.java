
package com.example.rostmanafinal.Pojo.PojoEnterPost;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plant implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("planttype")
    @Expose
    private Integer planttype;
    @SerializedName("temp")
    @Expose
    private Integer temp;
    @SerializedName("light")
    @Expose
    private Integer light;
    @SerializedName("humidity_soil")
    @Expose
    private Integer humiditySoil;
    @SerializedName("humidity_air")
    @Expose
    private Integer humidityAir;
    @SerializedName("soil_id")
    @Expose
    private Integer soilId;
    @SerializedName("fertilizer_id")
    @Expose
    private Integer fertilizerId;
    private final static long serialVersionUID = 5224008153164462797L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getPlanttype() {
        return planttype;
    }

    public void setPlanttype(Integer planttype) {
        this.planttype = planttype;
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

    public Integer getSoilId() {
        return soilId;
    }

    public void setSoilId(Integer soilId) {
        this.soilId = soilId;
    }

    public Integer getFertilizerId() {
        return fertilizerId;
    }

    public void setFertilizerId(Integer fertilizerId) {
        this.fertilizerId = fertilizerId;
    }

}
