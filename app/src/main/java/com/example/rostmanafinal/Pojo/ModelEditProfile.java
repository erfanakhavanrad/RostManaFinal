package com.example.rostmanafinal.Pojo;

import com.google.gson.annotations.SerializedName;

public class ModelEditProfile {
    @SerializedName("sex")
    private Boolean sex;
    @SerializedName("profileImage")
    private String profileImage;
    @SerializedName("name")
    private String name;
    @SerializedName("lastName")
    private String lastName;

    public ModelEditProfile(Boolean sex, String profileImage, String name, String lastName, String phonenumber, String address, String birth) {
        this.sex = sex;
        this.profileImage = profileImage;
        this.name = name;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
        this.address = address;
        this.birth = birth;
    }

    @SerializedName("phonenumber")
    private String phonenumber;
    @SerializedName("address")
    private String address;
    @SerializedName("birth")
    private String birth;

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
