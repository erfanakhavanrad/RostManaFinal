package com.example.rostmanafinal.Pojo;

public class PlantDetailClass {
    public PlantDetailClass(String pName, String id, int pic, String pNative, int temperature,
                            String humidity, String nebulaSprinkle, String watering, String light, String soilType,
                            String manure, String lop
    ) {

        setpName(pName);
        setId(id);
        setPic(pic);
        setpNative(pNative);
        setTemperature(temperature);
        setHumidity(humidity);
        setNebulaSprinkle(nebulaSprinkle);
        setWatering(watering);
        setLight(light);
        setSoilType(soilType);
        setManure(manure);
        setLop(lop);
    }


    private String pName;
    private String id;
    private int pic;
    private String pNative;
    private int temperature;
    private String humidity;
    private String nebulaSprinkle;
    private String watering;
    private String light;
    private String soilType;
    private String manure;
    private String lop;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getpNative() {
        return pNative;
    }

    public void setpNative(String pNative) {
        this.pNative = pNative;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getNebulaSprinkle() {
        return nebulaSprinkle;
    }

    public void setNebulaSprinkle(String nebulaSprinkle) {
        this.nebulaSprinkle = nebulaSprinkle;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getManure() {
        return manure;
    }

    public void setManure(String manure) {
        this.manure = manure;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
