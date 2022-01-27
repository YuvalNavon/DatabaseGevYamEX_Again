package com.example.databasegevyamex_again;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import static com.example.databasegevyamex_again.Worker.*;
import static com.example.databasegevyamex_again.Company.*;
import static com.example.databasegevyamex_again.Meal.*;

public class HelperDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GevYam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;

    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        strCreate="CREATE TABLE "+TABLE_WORKERS;
        strCreate+=" ("+KEY_NUMBER+" INTEGER,";
        strCreate+=" "+FIRST_NAME+" TEXT,";
        strCreate+=" "+LAST_NAME+" TEXT,";
        strCreate+=" "+COMPANY+" TEXT,";
        strCreate+=" "+ID_NUMBER+" TEXT,";
        strCreate+=" "+PHONE_NUMBER+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate+=" "+TAX_COMPANY+" TEXT,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+MAIN_NUMBER+" TEXT,";
        strCreate="CREATE TABLE "+TABLE_COMPANY;
        strCreate+=" "+SECONDARY_NUMBER+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_MEAL;
        strCreate+=" "+APPETIZER+" TEXT,";
        strCreate+=" "+MAIN_MEAL+" TEXT,";
        strCreate+=" "+EXTRA+" TEXT,";
        strCreate+=" "+DESSERT+" TEXT,";
        strCreate+=" "+DRINK+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

        strDelete="DROP TABLE IF EXISTS "+TABLE_WORKERS;
        db.execSQL(strDelete);
        strDelete="DROP TABLE IF EXISTS "+TABLE_COMPANY;
        db.execSQL(strDelete);
        strDelete="DROP TABLE IF EXISTS "+TABLE_MEAL;
        db.execSQL(strDelete);

        onCreate(db);
    }
}



