package com.ipmedt4.challengeweek_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charlie on 17-12-2014.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "StudentDB.db";
    public static final String TABLE_STUDENTEN = "Studenten";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAAM = "_naam";
    public static final String COLUMN_STUDENTNUMMER = "_studentnummer";
    public static final String COLUMN_KLAS = "_klas";
    public static final String COLUMN_CIJFER = "_cijfer";
    public static final String COLUMN_OPMERKINGEN = "_opmerkingen"



    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    String CREATE_STUDENTEN_TABLE = "CREATE TABLE" + TABLE_STUDENTEN + "(" + COLUMN_ID +
            "INTEGER PRIMARY KEY AUTOINCREMENT" + COLUMN_NAAM + "TEXT" + COLUMN_STUDENTNUMMER + "TEXT"
            + COLUMN_KLAS + "TEXT" + COLUMN_CIJFER + "INTEGER" + COLUMN_OPMERKINGEN + "TEXT" + ")";

        db.execSQL(CREATE_STUDENTEN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_STUDENTEN);

        onCreate(db);


    }

    public void beoordelingToevoegen(Beoordeling beoordeling){
        ContentValues values = new ContentValues();

        values.put(COLUMN_CIJFER, beoordeling.getCijfer());
        values.put(COLUMN_OPMERKINGEN, beoordeling.getOpmerkingen());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_STUDENTEN, null, values);
        db.close();


    }

}
