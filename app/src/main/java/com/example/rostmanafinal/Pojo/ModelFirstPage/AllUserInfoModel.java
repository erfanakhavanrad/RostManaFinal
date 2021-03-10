
package com.example.rostmanafinal.Pojo.ModelFirstPage;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllUserInfoModel implements Serializable, Parcelable
{

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("Builder")
    @Expose
    private List<Builder> builder = null;
    public final static Creator<AllUserInfoModel> CREATOR = new Creator<AllUserInfoModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AllUserInfoModel createFromParcel(Parcel in) {
            return new AllUserInfoModel(in);
        }

        public AllUserInfoModel[] newArray(int size) {
            return (new AllUserInfoModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6889815486144108099L;

    protected AllUserInfoModel(Parcel in) {
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        in.readList(this.builder, (Builder.class.getClassLoader()));
    }

    public AllUserInfoModel() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Builder> getBuilder() {
        return builder;
    }

    public void setBuilder(List<Builder> builder) {
        this.builder = builder;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(user);
        dest.writeList(builder);
    }

    public int describeContents() {
        return  0;
    }

}
