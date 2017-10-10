package com.apps.nishtha.shauswach.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nishita Aggarwal on 10-10-2017.
 */

public class UserDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "USERDATABASE";
    private static final String TABLE_NAME = "USER";
    //private static final String KEY_NO = "NO";
    private static final String KEY_REWPTS="REWARDPOINTS";

    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_TOILET_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_REWPTS + " INTEGER" + ")";
        database.execSQL(CREATE_TOILET_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public void addData()
    {
        Log.e("adddata","called");
        int rpts=readData();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_REWPTS, rpts+1); // Contact Name
        String delQuery="DELETE FROM "+ TABLE_NAME+" ;";
        if(rpts!=0)
        {
            db.execSQL(delQuery);
        }
        try {
            db.insert(TABLE_NAME, null, values);
        }
        catch (Exception e)
        {
            Log.e("INSERTDATA","failed");
        }
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public int readData() {
        int rpts;
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            rpts=Integer.parseInt(cursor.getString(0));
        }
        else{
            rpts=0;
        }
        return rpts;
    }
}
