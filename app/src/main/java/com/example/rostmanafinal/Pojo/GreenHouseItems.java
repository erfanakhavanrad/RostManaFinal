package com.example.rostmanafinal.Pojo;
// This was Items class

public class GreenHouseItems {
    private int type;
    private Object object;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public GreenHouseItems(int type, Object object) {
        this.type = type;
        this.object = object;
    }
}
