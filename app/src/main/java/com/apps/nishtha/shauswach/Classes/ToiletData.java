package com.apps.nishtha.shauswach.Classes;

/**
 * Created by Nishita Aggarwal on 10-10-2017.
 */

public class ToiletData {
    int toiletno;
    String toiletName;
    float rating;
    ToiletData()
    {
        rating=0;
    }

    public ToiletData(int num, String name)
    {
        toiletno=num;
        toiletName=name;
        rating =0;
    }

    public int getToiletno() {
        return toiletno;
    }

    public String getToiletName() {
        return toiletName;
    }

    public float getRating() {
        return rating;
    }

    public void setToiletno(int toiletno) {
        this.toiletno = toiletno;
    }

    public void setToiletName(String toiletName) {
        this.toiletName = toiletName;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

