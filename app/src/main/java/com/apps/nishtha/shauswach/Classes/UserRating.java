package com.apps.nishtha.shauswach.Classes;

/**
 * Created by nishtha on 10/10/17.
 */

public class UserRating {
    private float rating;
    private int toiletNo;

    public UserRating(float rating, int toiletNo) {
        this.rating = rating;
        this.toiletNo = toiletNo;
    }

    public float getRating() {
        return rating;
    }

    public int getToiletNo() {
        return toiletNo;
    }
}
