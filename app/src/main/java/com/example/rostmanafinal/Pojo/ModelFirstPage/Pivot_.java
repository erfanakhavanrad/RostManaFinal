
package com.example.rostmanafinal.Pojo.ModelFirstPage;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot_ implements Serializable, Parcelable
{

    @SerializedName("builder_id")
    @Expose
    private String builderId;
    @SerializedName("plant_id")
    @Expose
    private String plantId;
    public final static Creator<Pivot_> CREATOR = new Creator<Pivot_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pivot_ createFromParcel(Parcel in) {
            return new Pivot_(in);
        }

        public Pivot_[] newArray(int size) {
            return (new Pivot_[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3589513594692224195L;

    protected Pivot_(Parcel in) {
        this.builderId = ((String) in.readValue((String.class.getClassLoader())));
        this.plantId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Pivot_() {
    }

    public String getBuilderId() {
        return builderId;
    }

    public void setBuilderId(String builderId) {
        this.builderId = builderId;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(builderId);
        dest.writeValue(plantId);
    }

    public int describeContents() {
        return  0;
    }

}
