package com.example.apkapg;

import android.graphics.Bitmap;

public class ModelClass {

    private String imageName;
    private String imageName1;
    private String imageName2;
    private String imageName3;
    private String imageName4;
    private Bitmap image;

    public ModelClass(String imageName, String imageName1, String imageName2, String imageName3, String imageName4, Bitmap image) {
        this.imageName = imageName;
        this.imageName1 = imageName1;
        this.imageName2 = imageName2;
        this.imageName3 = imageName3;
        this.imageName4 = imageName4;
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName1() {
        return imageName1;
    }

    public void setImageName1(String imageName1) {
        this.imageName1 = imageName1;
    }

    public String getImageName2() {
        return imageName2;
    }

    public void setImageName2(String imageName2) {
        this.imageName2 = imageName2;
    }

    public String getImageName3() {
        return imageName3;
    }

    public void setImageName3(String imageName3) {
        this.imageName3 = imageName3;
    }

    public String getImageName4() {
        return imageName4;
    }

    public void setImageName4(String imageName4) {
        this.imageName4 = imageName4;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
