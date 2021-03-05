
package com.example.rostmanafinal.Pojo.ModelFirstPage;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Builder implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("qrcode")
    @Expose
    private String qrcode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("plant")
    @Expose
    private List<Plant_> plant = null;
    public final static Creator<Builder> CREATOR = new Creator<Builder>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Builder createFromParcel(Parcel in) {
            return new Builder(in);
        }

        public Builder[] newArray(int size) {
            return (new Builder[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1035097933306631573L;

    protected Builder(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((String) in.readValue((String.class.getClassLoader())));
        this.length = ((String) in.readValue((String.class.getClassLoader())));
        this.icon = ((String) in.readValue((String.class.getClassLoader())));
        this.picture = ((String) in.readValue((String.class.getClassLoader())));
        this.qrcode = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.plant, (Plant_.class.getClassLoader()));
    }

    public Builder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Plant_> getPlant() {
        return plant;
    }

    public void setPlant(List<Plant_> plant) {
        this.plant = plant;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(userId);
        dest.writeValue(name);
        dest.writeValue(model);
        dest.writeValue(width);
        dest.writeValue(length);
        dest.writeValue(icon);
        dest.writeValue(picture);
        dest.writeValue(qrcode);
        dest.writeValue(status);
        dest.writeList(plant);
    }

    public int describeContents() {
        return  0;
    }

}
