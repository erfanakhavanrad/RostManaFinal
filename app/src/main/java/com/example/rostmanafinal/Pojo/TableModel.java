package com.example.rostmanafinal.Pojo;

public class TableModel {

    private String watering;
    private String fan;
    private String element;
    private String lighting;
    private String fogger;

    public TableModel(String Watering, String Fan, String Element, String Lighting, String fogger) {
        this.watering = Watering;
        this.fan = Fan;
        this.element = Element;
        this.lighting = Lighting;
        this.fogger = fogger;
    }

    public String getWatering() {
        return watering;
    }

    public String getFan() {
        return fan;
    }

    public String getElement() {
        return element;
    }

    public String getFogger() {
        return fogger;
    }

    public String getLighting() {
        return lighting;
    }

}
