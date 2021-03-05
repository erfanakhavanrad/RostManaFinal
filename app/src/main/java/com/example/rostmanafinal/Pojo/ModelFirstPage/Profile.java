
package com.example.rostmanafinal.Pojo.ModelFirstPage;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile implements Serializable, Parcelable
{

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("Birth")
    @Expose
    private String birth;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    public final static Creator<Profile> CREATOR = new Creator<Profile>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        public Profile[] newArray(int size) {
            return (new Profile[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8716162413043262903L;

    protected Profile(Parcel in) {
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.firstname = ((String) in.readValue((String.class.getClassLoader())));
        this.lastname = ((String) in.readValue((String.class.getClassLoader())));
        this.sex = ((String) in.readValue((String.class.getClassLoader())));
        this.birth = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.avatar = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Profile() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(firstname);
        dest.writeValue(lastname);
        dest.writeValue(sex);
        dest.writeValue(birth);
        dest.writeValue(address);
        dest.writeValue(avatar);
    }

    public int describeContents() {
        return  0;
    }

}
