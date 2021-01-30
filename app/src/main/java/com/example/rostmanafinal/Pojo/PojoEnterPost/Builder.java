
package com.example.rostmanafinal.Pojo.PojoEnterPost;

import java.io.Serializable;

//import com.example.rostmanafinal.Plant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Builder implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("picture")
    @Expose
    private Integer picture;
    @SerializedName("qrcode")
    @Expose
    private String qrcode;
    @SerializedName("plant")
    @Expose
    private Plant plant;
    private final static long serialVersionUID = 9142916197656031296L;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPicture() {
        return picture;
    }

    public void setPicture(Integer picture) {
        this.picture = picture;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

}
