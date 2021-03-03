
package com.example.rostmanafinal.Pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketModel implements Serializable, Parcelable
{

    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<TicketModel> CREATOR = new Creator<TicketModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TicketModel createFromParcel(Parcel in) {
            return new TicketModel(in);
        }

        public TicketModel[] newArray(int size) {
            return (new TicketModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2770679826347767829L;

    protected TicketModel(Parcel in) {
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TicketModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
