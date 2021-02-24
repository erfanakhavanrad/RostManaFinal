
package com.example.rostmanafinal.Pojo.ModelChoosePlant;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plant implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("E_Name")
    @Expose
    private String eName;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("P_Water_S")
    @Expose
    private Integer pWaterS;
    @SerializedName("P_Water\u0640W")
    @Expose
    private Integer pWaterW;
    @SerializedName("time_fertilizer")
    @Expose
    private String timeFertilizer;
    @SerializedName("prune")
    @Expose
    private String prune;
    @SerializedName("description")
    @Expose
    private String description;
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
    public final static Creator<Plant> CREATOR = new Creator<Plant>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Plant createFromParcel(Parcel in) {
            return new Plant(in);
        }

        public Plant[] newArray(int size) {
            return (new Plant[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5865377318223317603L;

    protected Plant(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.eName = ((String) in.readValue((String.class.getClassLoader())));
        this.photo = ((String) in.readValue((String.class.getClassLoader())));
        this.pWaterS = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pWaterW = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.timeFertilizer = ((String) in.readValue((String.class.getClassLoader())));
        this.prune = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.planttype = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.temp = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.light = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.humiditySoil = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.humidityAir = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.soilId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fertilizerId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Plant() {
    }

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

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getPWaterS() {
        return pWaterS;
    }

    public void setPWaterS(Integer pWaterS) {
        this.pWaterS = pWaterS;
    }

    public Integer getPWaterW() {
        return pWaterW;
    }

    public void setPWaterW(Integer pWaterW) {
        this.pWaterW = pWaterW;
    }

    public String getTimeFertilizer() {
        return timeFertilizer;
    }

    public void setTimeFertilizer(String timeFertilizer) {
        this.timeFertilizer = timeFertilizer;
    }

    public String getPrune() {
        return prune;
    }

    public void setPrune(String prune) {
        this.prune = prune;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(eName);
        dest.writeValue(photo);
        dest.writeValue(pWaterS);
        dest.writeValue(pWaterW);
        dest.writeValue(timeFertilizer);
        dest.writeValue(prune);
        dest.writeValue(description);
        dest.writeValue(planttype);
        dest.writeValue(temp);
        dest.writeValue(light);
        dest.writeValue(humiditySoil);
        dest.writeValue(humidityAir);
        dest.writeValue(soilId);
        dest.writeValue(fertilizerId);
    }

    public int describeContents() {
        return  0;
    }

}
