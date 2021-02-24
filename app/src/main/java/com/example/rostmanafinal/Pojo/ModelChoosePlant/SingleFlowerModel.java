
package com.example.rostmanafinal.Pojo.ModelChoosePlant;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleFlowerModel implements Serializable, Parcelable
{

    @SerializedName("Plant")
    @Expose
    private Plant plant;
    public final static Creator<SingleFlowerModel> CREATOR = new Creator<SingleFlowerModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SingleFlowerModel createFromParcel(Parcel in) {
            return new SingleFlowerModel(in);
        }

        public SingleFlowerModel[] newArray(int size) {
            return (new SingleFlowerModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8124861695230827628L;

    protected SingleFlowerModel(Parcel in) {
        this.plant = ((Plant) in.readValue((Plant.class.getClassLoader())));
    }

    public SingleFlowerModel() {
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(plant);
    }

    public int describeContents() {
        return  0;
    }

}
