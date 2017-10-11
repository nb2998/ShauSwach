package com.apps.nishtha.shauswach.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Nishita Aggarwal on 10-10-2017.
 */

public class UserDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "USERDATABASE";
    private static final String TABLE_NAME = "USER";
    private static final String KEY_CNT = "CNT";
    private static final String KEY_REWPTS="REWARDPOINTS";

    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        String CREATE_TOILET_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_REWPTS + " INTEGER,"
                + KEY_CNT + " INTEGER"+")";
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
        UserData ud=readData();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_REWPTS, ud.getRwdpts()+1); // Contact Name
        values.put(KEY_CNT,ud.getCnt());
        String delQuery="DELETE FROM "+ TABLE_NAME+" ;";
        if(ud.getRwdpts()!=0)
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

    public void update(UserData ud){
        ContentValues cv=new ContentValues();
        cv.put(KEY_REWPTS,ud.getRwdpts());
        cv.put(KEY_CNT,ud.getCnt());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_NAME,cv,null,null);
        db.close();

    }
    public UserData readData() {
        Log.e("rpts(-1)=","");
        int rpts=0,cnt=0;
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("rpts0=",""+rpts);
        Cursor cursor = db.rawQuery(selectQuery, null);
        Log.e("rpts1=",""+rpts);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            rpts=Integer.parseInt(cursor.getString(0));
            Log.e("rpts=",""+rpts);
            cnt=Integer.parseInt(cursor.getString(1));
        }
        else{
            rpts=0;
        }
        Log.e("rpts2=",""+rpts);
        UserData ud=new UserData(rpts,cnt);
        return ud;
    }
}
