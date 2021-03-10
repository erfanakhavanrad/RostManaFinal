
package com.example.rostmanafinal.Pojo.ModelChartsTables;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChartsModel implements Serializable, Parcelable
{

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("Day")
    @Expose
    private String day;
    @SerializedName("temp")
    @Expose
    private String temp;
    @SerializedName("humidity_air")
    @Expose
    private String humidityAir;
    @SerializedName("humidity_soil")
    @Expose
    private String humiditySoil;
    @SerializedName("Num_OFF_FAN")
    @Expose
    private Integer numOFFFAN;
    @SerializedName("Num_OFF_Fogger")
    @Expose
    private Integer numOFFFogger;
    @SerializedName("Num_OFF_light")
    @Expose
    private Integer numOFFLight;
    @SerializedName("Num_OFF_pump_w")
    @Expose
    private Integer numOFFPumpW;
    @SerializedName("num_ON_Element")
    @Expose
    private Integer numONElement;
    public final static Creator<ChartsModel> CREATOR = new Creator<ChartsModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ChartsModel createFromParcel(Parcel in) {
            return new ChartsModel(in);
        }

        public ChartsModel[] newArray(int size) {
            return (new ChartsModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4169721022593303707L;

    protected ChartsModel(Parcel in) {
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.day = ((String) in.readValue((String.class.getClassLoader())));
        this.temp = ((String) in.readValue((String.class.getClassLoader())));
        this.humidityAir = ((String) in.readValue((String.class.getClassLoader())));
        this.humiditySoil = ((String) in.readValue((String.class.getClassLoader())));
        this.numOFFFAN = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.numOFFFogger = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.numOFFLight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.numOFFPumpW = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.numONElement = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public ChartsModel() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidityAir() {
        return humidityAir;
    }

    public void setHumidityAir(String humidityAir) {
        this.humidityAir = humidityAir;
    }

    public String getHumiditySoil() {
        return humiditySoil;
    }

    public void setHumiditySoil(String humiditySoil) {
        this.humiditySoil = humiditySoil;
    }

    public Integer getNumOFFFAN() {
        return numOFFFAN;
    }

    public void setNumOFFFAN(Integer numOFFFAN) {
        this.numOFFFAN = numOFFFAN;
    }

    public Integer getNumOFFFogger() {
        return numOFFFogger;
    }

    public void setNumOFFFogger(Integer numOFFFogger) {
        this.numOFFFogger = numOFFFogger;
    }

    public Integer getNumOFFLight() {
        return numOFFLight;
    }

    public void setNumOFFLight(Integer numOFFLight) {
        this.numOFFLight = numOFFLight;
    }

    public Integer getNumOFFPumpW() {
        return numOFFPumpW;
    }

    public void setNumOFFPumpW(Integer numOFFPumpW) {
        this.numOFFPumpW = numOFFPumpW;
    }

    public Integer getNumONElement() {
        return numONElement;
    }

    public void setNumONElement(Integer numONElement) {
        this.numONElement = numONElement;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(time);
        dest.writeValue(day);
        dest.writeValue(temp);
        dest.writeValue(humidityAir);
        dest.writeValue(humiditySoil);
        dest.writeValue(numOFFFAN);
        dest.writeValue(numOFFFogger);
        dest.writeValue(numOFFLight);
        dest.writeValue(numOFFPumpW);
        dest.writeValue(numONElement);
    }

    public int describeContents() {
        return  0;
    }

}
