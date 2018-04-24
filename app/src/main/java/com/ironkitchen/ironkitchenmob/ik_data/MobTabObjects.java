package com.ironkitchen.ironkitchenmob.ik_data;

/**
 * Created by jeretgoad on 1/25/18.
 */

public class MobTabObjects {
    private String mealType;
    private int imageID;
    private int videoID;
    private int isButton;

    public MobTabObjects(String mealType, int imageID, int videoID, int isButton)
    {
        this.mealType = mealType;
        this.imageID = imageID;
        this.videoID = videoID;
        this.isButton = isButton;
    }

    public String getMealType() {
        return mealType;
    }

    public int getImageID() {
        return imageID;
    }

    public int getVideoID() {
        return videoID;
    }

    public int getIsButton() {
        return isButton;
    }
}
