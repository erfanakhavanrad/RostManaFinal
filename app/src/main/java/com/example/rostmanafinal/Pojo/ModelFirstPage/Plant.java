
package com.example.rostmanafinal.Pojo.ModelFirstPage;

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
    private String pWaterS;
    @SerializedName("P_Water\u0640W")
    @Expose
    private String pWaterW;
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
    private String planttype;
    @SerializedName("temp")
    @Expose
    private String temp;
    @SerializedName("temp-to")
    @Expose
    private String tempTo;
    @SerializedName("light")
    @Expose
    private String light;
    @SerializedName("humidity_soil")
    @Expose
    private String humiditySoil;
    @SerializedName("humidity_air")
    @Expose
    private String humidityAir;
    @SerializedName("humidity_air_to")
    @Expose
    private String humidityAirTo;
    @SerializedName("soil_id")
    @Expose
    private String soilId;
    @SerializedName("fertilizer_id")
    @Expose
    private String fertilizerId;
    @SerializedName("pivot")
    @Expose
    private Pivot pivot;
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
    private final static long serialVersionUID = 3217494137685870471L;

    protected Plant(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.eName = ((String) in.readValue((String.class.getClassLoader())));
        this.photo = ((String) in.readValue((String.class.getClassLoader())));
        this.pWaterS = ((String) in.readValue((String.class.getClassLoader())));
        this.pWaterW = ((String) in.readValue((String.class.getClassLoader())));
        this.timeFertilizer = ((String) in.readValue((String.class.getClassLoader())));
        this.prune = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.planttype = ((String) in.readValue((String.class.getClassLoader())));
        this.temp = ((String) in.readValue((String.class.getClassLoader())));
        this.tempTo = ((String) in.readValue((String.class.getClassLoader())));
        this.light = ((String) in.readValue((String.class.getClassLoader())));
        this.humiditySoil = ((String) in.readValue((String.class.getClassLoader())));
        this.humidityAir = ((String) in.readValue((String.class.getClassLoader())));
        this.humidityAirTo = ((String) in.readValue((String.class.getClassLoader())));
        this.soilId = ((String) in.readValue((String.class.getClassLoader())));
        this.fertilizerId = ((String) in.readValue((String.class.getClassLoader())));
        this.pivot = ((Pivot) in.readValue((Pivot.class.getClassLoader())));
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

    public String getPWaterS() {
        return pWaterS;
    }

    public void setPWaterS(String pWaterS) {
        this.pWaterS = pWaterS;
    }

    public String getPWaterW() {
        return pWaterW;
    }

    public void setPWaterW(String pWaterW) {
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

    public String getPlanttype() {
        return planttype;
    }

    public void setPlanttype(String planttype) {
        this.planttype = planttype;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTempTo() {
        return tempTo;
    }

    public void setTempTo(String tempTo) {
        this.tempTo = tempTo;
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

    public String getHumidityAirTo() {
        return humidityAirTo;
    }

    public void setHumidityAirTo(String humidityAirTo) {
        this.humidityAirTo = humidityAirTo;
    }

    public String getSoilId() {
        return soilId;
    }

    public void setSoilId(String soilId) {
        this.soilId = soilId;
    }

    public String getFertilizerId() {
        return fertilizerId;
    }

    public void setFertilizerId(String fertilizerId) {
        this.fertilizerId = fertilizerId;
    }

    public Pivot getPivot() {
        return pivot;
    }

    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
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
        dest.writeValue(tempTo);
        dest.writeValue(light);
        dest.writeValue(humiditySoil);
        dest.writeValue(humidityAir);
        dest.writeValue(humidityAirTo);
        dest.writeValue(soilId);
        dest.writeValue(fertilizerId);
        dest.writeValue(pivot);
    }

    public int describeContents() {
        return  0;
    }

}
