package com.ipmedt4.challengeweek_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Charlie on 28-12-2014.
 */
public class StudentDBAdapter {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAAM = "_naam";
    public static final String KEY_STUDENTNUMMER = "_studentnummer";
    public static final String KEY_KLAS = "_klas";
    public static final String KEY_CIJFER = "_cijfer";
    public static final String KEY_OPMERKINGEN = "_opmerkingen";

    private static  final String TAG = "StudentDBAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDB;

    private static final String DATABASE_NAME = "Challengeweek";
    private static final String SQLITE_TABLE = "Studenten";
    private static final int DATABASE_VERSION = 1;

    private final Context mCtx;

    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS" + SQLITE_TABLE + "(" +
            KEY_ROWID + "INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAAM + "," + KEY_STUDENTNUMMER + ","
            + KEY_KLAS + "," + KEY_CIJFER + "," + KEY_OPMERKINGEN + "," + ")";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            Log.w(TAG, DATABASE_CREATE);
        }

        @Override
        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
          Log.w(TAG, "Upgrading database from veriosn" + oldVersion + "to" + newVersion +
                  "which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS" + SQLITE_TABLE);
            onCreate(db);
        }
    }

    public StudentDBAdapter (Context ctx){
        this.mCtx = ctx;
    }
    public StudentDBAdapter open () throws SQLiteException{
        mDbHelper = new DatabaseHelper(mCtx);
        mDB = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }
    public long createStudent (String naam, String studentnummer, String klas){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAAM, naam);
        initialValues.put(KEY_STUDENTNUMMER, studentnummer);
        initialValues.put(KEY_KLAS, klas);

        return mDB.insert(SQLITE_TABLE, null, initialValues);
    }

    public boolean deleteAllStudenten(){
        int doneDelete = 0;
        doneDelete = mDB.delete(SQLITE_TABLE, null, null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

    public Cursor fetchStudentenbyName(String inputText) throws SQLiteException{
    Log.w(TAG, inputText);
    Cursor mCursor = null;
        if (inputText == null || inputText.length() == 0){
            mCursor = mDB.query(SQLITE_TABLE, new String[] {
                    KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS
            }, null, null, null, null, null);
        }
        else {
            mCursor = mDB.query(true, SQLITE_TABLE, new String [] {KEY_ROWID,
            KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS}, KEY_NAAM + "like '%" + inputText +
            "%'", null, null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

   public Cursor showAlleStudenten(){
       Cursor mCursor = mDB.query(SQLITE_TABLE, new String[] {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER,
       KEY_KLAS}, null, null, null, null, null);

       if (mCursor != null){
           mCursor.moveToFirst();
       }
       return mCursor;
   }
    public void insertStudenten(){
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");
        createStudent("Adel, Pieter", "s1078455", "INF1G");


    }
}
