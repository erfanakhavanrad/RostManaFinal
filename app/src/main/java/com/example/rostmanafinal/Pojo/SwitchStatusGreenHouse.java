package com.example.rostmanafinal.Pojo;
// This was Ads class

public class SwitchStatusGreenHouse {

    private String switchStatusTitle, switchStatus;
    private int switchStatusImage;

    public String getSwitchStatusTitle() {
        return switchStatusTitle;
    }

    public void setSwitchStatusTitle(String switchStatusTitle) {
        this.switchStatusTitle = switchStatusTitle;
    }

    public String getSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(String switchStatus) {
        this.switchStatus = switchStatus;
    }

    public int getSwitchStatusImage() {
        return switchStatusImage;
    }

    public void setSwitchStatusImage(int switchStatusImage) {
        this.switchStatusImage = switchStatusImage;
    }

    public boolean isSwitchStatusOn() {
        return switchStatusOn;
    }

    public void setSwitchStatusOn(boolean switchStatusOn) {
        this.switchStatusOn = switchStatusOn;
    }

    public SwitchStatusGreenHouse(String switchStatusTitle, String switchStatus, int switchStatusImage, boolean switchStatusOn) {
        this.switchStatusTitle = switchStatusTitle;
        this.switchStatus = switchStatus;
        this.switchStatusImage = switchStatusImage;
        this.switchStatusOn = switchStatusOn;
    }

    private boolean switchStatusOn;
}
