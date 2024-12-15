package com.example.blooddonation2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mydbhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "blooddonation.db";
    private static final int DATABASE_VERSION = 1;

    // Table and column names
    private static final String TABLE_NAME = "users";
    private static final String COL_ID = "ID"; // Corrected as a String for column name
    private static final String USER_NAME = "NAME";
    private static final String USER_PHONE = "PHONE";
    private static final String USER_BLOODGROUP = "BLOODGROUP";

    public mydbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // Corrected context parameter
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Corrected CREATE TABLE query
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT, " +
                USER_PHONE + " TEXT, " +
                USER_BLOODGROUP + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void adduser(String name, String phone, String bloodgroup){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME + " (" + USER_NAME + ", " + USER_PHONE + ", " + USER_BLOODGROUP + ") VALUES (?, ?, ?)";
        db.execSQL(query, new String[]{name, phone, bloodgroup});
    }
    Cursor readAllData(){
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
