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

public class ToiletDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TOILETDATABASE";
    private static final String TABLE_NAME = "TOILET";
    private static final String KEY_NO = "NO";
    private static final String KEY_NAME="NAME";
    private static final String KEY_RATING="RATING";

    public ToiletDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_TOILET_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_NO + " INTEGER,"
                + KEY_NAME + " TEXT" + ")";
        database.execSQL(CREATE_TOILET_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }
    public void addData(ToiletData d)
    {
        Log.e("adddata","called");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NO, d.toiletno); // Contact Name
        //values.put(KEY_DATE,d1.toString());
        values.put(KEY_NAME,d.toiletName);

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
    public List<ToiletData> readData() {
        List<ToiletData> dataList = new ArrayList<ToiletData>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Log.e("in readData","start");
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ToiletData d = new ToiletData();
                d.toiletno=Integer.parseInt(cursor.getString(0));
                d.toiletName=cursor.getString(1);
                // Adding toiletdata to list
                dataList.add(d);
                Log.e("in getAllcont",dataList.toString());
            } while (cursor.moveToNext());
        }
        return dataList;
    }
}


}
