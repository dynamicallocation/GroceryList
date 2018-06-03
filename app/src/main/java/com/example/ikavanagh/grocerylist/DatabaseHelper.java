package com.example.ikavanagh.grocerylist;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "market.db";
    private static final String TABLE_NAME = "groceries";
    private static final int DATABASE_VERSION = 1;
    private static final String COL_1 = "ID";
    private static final String COL_2 = "ITEM";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " ITEM TEXT)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean addData(Grocery grocery)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,grocery.getName());
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}
