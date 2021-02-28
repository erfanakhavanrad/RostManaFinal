
package com.example.rostmanafinal.Pojo.ModelMonitoring;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChartModel implements Serializable, Parcelable
{

    @SerializedName("log")
    @Expose
    private List<Log> log = null;
    public final static Creator<ChartModel> CREATOR = new Creator<ChartModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ChartModel createFromParcel(Parcel in) {
            return new ChartModel(in);
        }

        public ChartModel[] newArray(int size) {
            return (new ChartModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8787129242510155438L;

    protected ChartModel(Parcel in) {
        in.readList(this.log, (Log.class.getClassLoader()));
    }

    public ChartModel() {
    }

    public List<Log> getLog() {
        return log;
    }

    public void setLog(List<Log> log) {
        this.log = log;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(log);
    }

    public int describeContents() {
        return  0;
    }

}
