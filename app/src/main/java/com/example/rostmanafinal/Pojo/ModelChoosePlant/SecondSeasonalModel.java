package com.example.rostmanafinal.Pojo.ModelChoosePlant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SecondSeasonalModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;

    public SecondSeasonalModel(Integer id, String name, Object eName, String photo, Object pWaterS, Object pWaterW, Object timeFertilizer, Object prune, Object description, Integer planttype, Integer temp, Integer light, Integer humiditySoil, Integer humidityAir, Integer soilId, Integer fertilizerId) {
        this.id = id;
        this.name = name;
        this.eName = eName;
        this.photo = photo;
        this.pWaterS = pWaterS;
        this.pWaterW = pWaterW;
        this.timeFertilizer = timeFertilizer;
        this.prune = prune;
        this.description = description;
        this.planttype = planttype;
        this.temp = temp;
        this.light = light;
        this.humiditySoil = humiditySoil;
        this.humidityAir = humidityAir;
        this.soilId = soilId;
        this.fertilizerId = fertilizerId;
    }

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
        if (eName != null)
            return eName;
        else return "نامشخص";
    }

    public void setEName(Object eName) {
        this.eName = eName;
    }

    public String getPhoto() {
        if (photo != null)
            return photo;
        else return "نامشخص";
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Object getPWaterS() {
        if (pWaterS != null)
            return pWaterS;
        else return "نامشخص";
    }

    public void setPWaterS(Object pWaterS) {
        this.pWaterS = pWaterS;
    }

    public Object getPWaterW() {
        if (pWaterW != null)
            return pWaterW;
        else return "نامشخص";
    }

    public void setPWaterW(Object pWaterW) {
        this.pWaterW = pWaterW;
    }

    public Object getTimeFertilizer() {
        if (timeFertilizer != null)
            return timeFertilizer;
        else return "نامشخص";
    }

    public void setTimeFertilizer(Object timeFertilizer) {
        this.timeFertilizer = timeFertilizer;
    }

    public Object getPrune() {
        if (prune != null)
            return prune;
        else return "نامشخص";
    }

    public void setPrune(Object prune) {
        this.prune = prune;
    }

    public Object getDescription() {
        if (description != null)
            return description;
        else return "نامشخص";
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Integer getPlanttype() {
        if (planttype != null)
            return planttype;
        else return 0;
    }

    public void setPlanttype(Integer planttype) {
        this.planttype = planttype;
    }

    public Integer getTemp() {
        if (temp != null)
            return temp;
        else return 0;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getLight() {
        if (light != null)
            return light;
        else return 0;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getHumiditySoil() {
        if (humiditySoil != null)
            return humiditySoil;
        else return 0;
    }

    public void setHumiditySoil(Integer humiditySoil) {
        this.humiditySoil = humiditySoil;
    }

    public Integer getHumidityAir() {
        if (humidityAir != null)
            return humidityAir;
        else return 0;
    }

    public void setHumidityAir(Integer humidityAir) {
        this.humidityAir = humidityAir;
    }

    public Integer getSoilId() {
        if (soilId != null)
            return soilId;
        else return 0;
    }

    public void setSoilId(Integer soilId) {
        this.soilId = soilId;
    }

    public Integer getFertilizerId() {
        if (fertilizerId != null)
            return fertilizerId;
        else return 0;
    }

    public void setFertilizerId(Integer fertilizerId) {
        this.fertilizerId = fertilizerId;
    }
}
