package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.SerializedName;

public class Builder {
    @SerializedName("User")
    private String user;

    @SerializedName("Builder")
    private String builder;
    @SerializedName("name")
    private String name;
    @SerializedName("model")
    private String model;
    @SerializedName("width")
    private String width;
    @SerializedName("length")
    private String length;
    @SerializedName("icon")
    private String icon;
    @SerializedName("picture")
    private String picture;
    @SerializedName("qrcode")
    private String qrcode;
    @SerializedName("plant")
    private String plant;
    @SerializedName("photo")
    private String photo;
    @SerializedName("planttype")
    private String planttype;
    @SerializedName("temp")
    private String temp;
    @SerializedName("light")
    private String light;
    @SerializedName("humidity_soil")
    private String humidity_soil;
    @SerializedName("humidity_air")
    private String humidity_air;
    @SerializedName("soil_id")
    private String soil_id;
    @SerializedName("fertilizer_id")
    private String fertilizer_id;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getHumidity_soil() {
        return humidity_soil;
    }

    public void setHumidity_soil(String humidity_soil) {
        this.humidity_soil = humidity_soil;
    }

    public String getHumidity_air() {
        return humidity_air;
    }

    public void setHumidity_air(String humidity_air) {
        this.humidity_air = humidity_air;
    }

    public String getSoil_id() {
        return soil_id;
    }

    public void setSoil_id(String soil_id) {
        this.soil_id = soil_id;
    }

    public String getFertilizer_id() {
        return fertilizer_id;
    }

    public void setFertilizer_id(String fertilizer_id) {
        this.fertilizer_id = fertilizer_id;
    }
}
