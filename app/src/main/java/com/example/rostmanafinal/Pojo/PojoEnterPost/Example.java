
package com.example.rostmanafinal.Pojo.PojoEnterPost;

import java.io.Serializable;
import java.util.List;

//import com.example.rostmanafinal.Profile_;
//import com.example.rostmanafinal.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example implements Serializable
{

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("builder")
    @Expose
    private List<Builder> builder = null;
    @SerializedName("profile")
    @Expose
    private Profile_ profile;
    private final static long serialVersionUID = -2391689143684116804L;

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

    public Profile_ getProfile() {
        return profile;
    }

    public void setProfile(Profile_ profile) {
        this.profile = profile;
    }

}
