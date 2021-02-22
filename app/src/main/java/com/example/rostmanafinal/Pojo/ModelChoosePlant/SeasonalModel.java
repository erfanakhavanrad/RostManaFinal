
package com.example.rostmanafinal.Pojo.ModelChoosePlant;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeasonalModel implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("E_Name")
    @Expose
    private Object eName;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("P_Water_S")
    @Expose
    private Object pWaterS;
    @SerializedName("P_Water\u0640W")
    @Expose
    private Object pWaterW;
    @SerializedName("time_fertilizer")
    @Expose
    private Object timeFertilizer;
    @SerializedName("prune")
    @Expose
    private Object prune;
    @SerializedName("description")
    @Expose
    private Object description;
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
    private final static long serialVersionUID = 8074431600415594726L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getEName() {
        return eName;
    }

    public void setEName(Object eName) {
        this.eName = eName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Object getPWaterS() {
        return pWaterS;
    }

    public void setPWaterS(Object pWaterS) {
        this.pWaterS = pWaterS;
    }

    public Object getPWaterW() {
        return pWaterW;
    }

    public void setPWaterW(Object pWaterW) {
        this.pWaterW = pWaterW;
    }

    public Object getTimeFertilizer() {
        return timeFertilizer;
    }

    public void setTimeFertilizer(Object timeFertilizer) {
        this.timeFertilizer = timeFertilizer;
    }

    public Object getPrune() {
        return prune;
    }

    public void setPrune(Object prune) {
        this.prune = prune;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
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
