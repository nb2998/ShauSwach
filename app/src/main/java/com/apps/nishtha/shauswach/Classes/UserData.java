package com.apps.nishtha.shauswach.Classes;

/**
 * Created by nishtha on 11/10/17.
 */

public class UserData {

    int rwdpts, cnt;

    public int getRwdpts() {
        return rwdpts;
    }

    public int getCnt() {
        return cnt;
    }

    public void setRwdpts(int rwdpts) {

        this.rwdpts = rwdpts;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public UserData(int rwdpts, int cnt) {

        this.rwdpts = rwdpts;
        this.cnt = cnt;
    }
}
