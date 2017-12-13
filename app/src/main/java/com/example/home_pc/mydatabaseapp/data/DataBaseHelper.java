package com.example.home_pc.mydatabaseapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.home_pc.mydatabaseapp.data.CatsContract.CatsEntry;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "DATABASE_NAME";
    public static int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         sqLiteDatabase.execSQL("CREATE TABLE " + CatsEntry.TABLE_NAME + " ("
                + CatsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CatsEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + CatsEntry.COLUMN_AGE + " TEXT NOT NULL);"
        );

        insertData(sqLiteDatabase, "Барсик", "9");
        insertData(sqLiteDatabase, "Марсик", "2");
        insertData(sqLiteDatabase, "Китикет", "12");
        insertData(sqLiteDatabase, "Барсик", "9");
        insertData(sqLiteDatabase, "Муркет", "4");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    static void insertData(SQLiteDatabase db, String name, String age) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("AGE", age);
        db.insert("CATS", null, contentValues);
    }
}
