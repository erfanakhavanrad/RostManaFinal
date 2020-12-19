package com.example.rostmanafinal.Pojo;

//This was Trip class

public class FogFunctionByUser {
    private int FogImage;
    private String fogTitle, fogFunctions;

    public int getFogImage() {
        return FogImage;
    }

    public void setFogImage(int fogImage) {
        FogImage = fogImage;
    }

    public String getFogTitle() {
        return fogTitle;
    }

    public void setFogTitle(String fogTitle) {
        this.fogTitle = fogTitle;
    }

    public String getFogFunctions() {
        return fogFunctions;
    }

    public void setFogFunctions(String fogFunctions) {
        this.fogFunctions = fogFunctions;
    }

    public FogFunctionByUser(int fogImage, String fogTitle, String fogFunctions) {
        FogImage = fogImage;
        this.fogTitle = fogTitle;
        this.fogFunctions = fogFunctions;
    }
}
