package com.example.rostmanafinal.Pojo;

import java.util.List;

public class ResponseObj {
    public List<Builder> getBuilder() {
        return builder;
    }

    public void setBuilder(List<Builder> builder) {
        this.builder = builder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private List<Builder> builder;
private User user;
}
