package com.apps.nishtha.shauswach;

/**
 * Created by nishtha on 10/10/17.
 */

public class Card {
    private String title;
    private int resId;

    public Card(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public int getResId() {
        return resId;
    }
}
