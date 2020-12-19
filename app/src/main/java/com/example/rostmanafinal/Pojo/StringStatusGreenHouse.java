package com.example.rostmanafinal.Pojo;
// This was news class

public class StringStatusGreenHouse {

    private String stringStatusTitle, StringStatus;
    private int StringStatusImage;

    public String getStringStatusTitle() {
        return stringStatusTitle;
    }

    public void setStringStatusTitle(String stringStatusTitle) {
        this.stringStatusTitle = stringStatusTitle;
    }

    public String getStringStatus() {
        return StringStatus;
    }

    public void setStringStatus(String stringStatus) {
        StringStatus = stringStatus;
    }

    public int getStringStatusImage() {
        return StringStatusImage;
    }

    public void setStringStatusImage(int stringStatusImage) {
        StringStatusImage = stringStatusImage;
    }

    public StringStatusGreenHouse(String stringStatusTitle, String stringStatus, int stringStatusImage) {
        this.stringStatusTitle = stringStatusTitle;
        StringStatus = stringStatus;
        StringStatusImage = stringStatusImage;
    }
}
