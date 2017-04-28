package com.example.david.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    //DB Version
    private static final int DATABASE_VERSION = 1;
    //Database proper
    private static final String DATABASE_NAME = "Stats.db";
    private static final String TABLE_NAME = "Stats_table";
    public static final String COL_1 = "ID";
    private static final String COL_2 = "HEIGHT";
    private static final String COL_3 = "WEIGHT";
    private static final String COL_4 = "ACTIVITY_LEVEL";

    private static final String TABLE_NAME2 ="Workout_Table";
    private static final String COL_5 = "WORKOUT_NAME";
    private static final String COL_6 = "INTENSITY";
    private static final String COL_7 = "LENGTH";
    private static final String COL_8 = "CALORIES_BURNED";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, HEIGHT INTEGER, WEIGHT INTEGER, ACTIVITY_LEVEL INTEGER)");
        db.execSQL("CREATE TABLE"+ TABLE_NAME2+"(WORKOUT_NAME VARCHAR, INTENSITY VARCHAR, LENGTH INTEGER, CALORIES_BURNED INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    public boolean insertUser(int height, int weight, int activityLevel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, height);
        contentValues.put(COL_3, weight);
        contentValues.put(COL_4, activityLevel);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        }
        else
            return true;
    }

    public boolean insertWorkout(String workout_name, String intensity, int length, int calories_burned){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5, workout_name);
        contentValues.put(COL_6, intensity);
        contentValues.put(COL_7, length);
        contentValues.put(COL_8, calories_burned);
        long result2 = db.insert(TABLE_NAME2, null, contentValues);
        if (result2 == -1){
            return false;
        }
        else
            return true;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
