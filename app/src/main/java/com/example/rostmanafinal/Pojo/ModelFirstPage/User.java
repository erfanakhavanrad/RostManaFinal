
package com.example.rostmanafinal.Pojo.ModelFirstPage;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("is_admin")
    @Expose
    private String isAdmin;
    @SerializedName("email_verified_at")
    @Expose
    private Object emailVerifiedAt;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("plants")
    @Expose
    private List<Plant> plants = null;
    public final static Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3288218698569370743L;

    protected User(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.phonenumber = ((String) in.readValue((String.class.getClassLoader())));
        this.isAdmin = ((String) in.readValue((String.class.getClassLoader())));
        this.emailVerifiedAt = ((Object) in.readValue((Object.class.getClassLoader())));
        this.profile = ((Profile) in.readValue((Profile.class.getClassLoader())));
//        in.readList(this.plants, (com.example.Plant.class.getClassLoader()));
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(phonenumber);
        dest.writeValue(isAdmin);
        dest.writeValue(emailVerifiedAt);
        dest.writeValue(profile);
        dest.writeList(plants);
    }

    public int describeContents() {
        return  0;
    }

}
