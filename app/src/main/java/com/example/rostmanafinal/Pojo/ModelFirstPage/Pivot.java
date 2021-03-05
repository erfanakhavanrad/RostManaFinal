
package com.example.rostmanafinal.Pojo.ModelFirstPage;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot implements Serializable, Parcelable
{

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("plant_id")
    @Expose
    private String plantId;
    public final static Creator<Pivot> CREATOR = new Creator<Pivot>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pivot createFromParcel(Parcel in) {
            return new Pivot(in);
        }

        public Pivot[] newArray(int size) {
            return (new Pivot[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6852350072617320408L;

    protected Pivot(Parcel in) {
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.plantId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Pivot() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(plantId);
    }

    public int describeContents() {
        return  0;
    }

}
