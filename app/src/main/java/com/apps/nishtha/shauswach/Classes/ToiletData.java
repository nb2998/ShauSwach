package com.apps.nishtha.shauswach.Classes;

import static android.R.attr.rating;
import static android.R.string.no;

/**
 * Created by Nishita Aggarwal on 10-10-2017.
 */

public class ToiletData {
    int toiletno,yes,wrong;
    String toiletName;

    ToiletData()
    {
        yes=wrong=0;
    }

    public ToiletData(int num, String name)
    {
        toiletno=num;
        toiletName=name;
        yes=wrong=0;
    }

    public int getToiletno() {
        return toiletno;
    }

    public String getToiletName() {
        return toiletName;
    }

    public int getWrong() {
        return wrong;
    }

    public int getYes() {
        return yes;

    }

    public void setToiletno(int toiletno) {
        this.toiletno = toiletno;
    }

    public void setToiletName(String toiletName) {
        this.toiletName = toiletName;
    }

}

