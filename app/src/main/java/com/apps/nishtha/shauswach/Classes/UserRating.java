package com.apps.nishtha.shauswach.Classes;

/**
 * Created by nishtha on 10/10/17.
 */

public class UserRating {
    private float rating;
    private int toiletNo;
    private String toiletName;

    public UserRating(float rating, int toiletNo, String toiletName) {
        this.rating = rating;
        this.toiletNo = toiletNo;
        this.toiletName = toiletName;
    }

    public float getRating() {
        return rating;
    }

    public int getToiletNo() {
        return toiletNo;
    }

    public String getToiletName() {
        return toiletName;
    }
}
