
package com.example.rostmanafinal.Pojo.ModelSMS;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyModel implements Serializable
{

    @SerializedName("User")
    @Expose
    private User user;
    private final static long serialVersionUID = 3161095585761825087L;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
