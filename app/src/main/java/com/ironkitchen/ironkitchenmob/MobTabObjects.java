package com.ironkitchen.ironkitchenmob;

/**
 * Created by jeretgoad on 1/25/18.
 */

public class MobTabObjects {
    String mealType;
    int imageID;
    int videoID;
    int isButton;

    public MobTabObjects(String mealType, int imageID, int isButton)
    {
        this.mealType = mealType;
        this.imageID = imageID;
        this.videoID = 0;
        this.isButton = isButton;
    }

    public MobTabObjects(int imageID, int isButton)
    {
        this.mealType = "";
        this.imageID = imageID;
        this.videoID = 0;
        this.isButton = isButton;
    }

    public MobTabObjects(int imageID, int videoID, int isButton)
    {
        this.mealType = "";
        this.imageID = imageID;
        this.videoID = videoID;
        this.isButton = isButton;
    }
}
