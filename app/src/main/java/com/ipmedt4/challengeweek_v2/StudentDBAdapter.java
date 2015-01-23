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
    public static final String KEY_GROEP = "_groep";
    public static final String KEY_CIJFER = "_cijfer";
    public static final String KEY_OPMERKINGEN = "_opmerkingen";

    private static  final String TAG = "StudentDBAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDB;

    private static final String DATABASE_NAME = "Challengeweek";
    private static final String SQLITE_TABLE = "Studenten";
    private static final int DATABASE_VERSION = 1;

    private final Context mCtx;

    private static final String DATABASE_CREATE = " CREATE TABLE IF NOT EXISTS " + SQLITE_TABLE + "(" +
            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAAM + "," + KEY_STUDENTNUMMER + ","
            + KEY_KLAS + "," + KEY_GROEP + "," + KEY_CIJFER + "," + KEY_OPMERKINGEN +  ")";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
          Log.w(TAG, "Upgrading database from version" + oldVersion + "to" + newVersion +
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
    public long createStudent (String naam, String studentnummer, String klas, String groep){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAAM, naam);
        initialValues.put(KEY_STUDENTNUMMER, studentnummer);
        initialValues.put(KEY_KLAS, klas);
        initialValues.put(KEY_GROEP, groep);

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
       return mCursor;}

    public Cursor SelecteerStudenten1A(){
        String Table = "Studenten";
        String [] fields = {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS, KEY_GROEP};
        String where = "_klas = 'INF1A'";
        Cursor mCursor = mDB.query(Table, fields, where, null, null, null, null);

        if(mCursor !=null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public void OpmerkingenOpslaan(String opmerkingen){
        mDB.insert(SQLITE_TABLE, KEY_OPMERKINGEN + "=" + KEY_NAAM, null);

    }



    public Cursor SelecteerStudenten1B(){
        String Table = "Studenten";
        String [] fields = {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS, KEY_GROEP};
        String where = "_klas = 'INF1B'";
        Cursor mCursor = mDB.query(Table, fields, where, null, null, null, null);
        if(mCursor !=null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor SelecteerStudenten1C(){
        String Table = "Studenten";
        String [] fields = {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS, KEY_GROEP};
        String where = "_klas = 'INF1C'";
        Cursor mCursor = mDB.query(Table, fields, where, null, null, null, null);
        if(mCursor !=null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor SelecteerStudenten1D(){
        String Table = "Studenten";
        String [] fields = {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS, KEY_GROEP};
        String where = "_klas = 'INF1D'";
        Cursor mCursor = mDB.query(Table, fields, where, null, null, null, null);
        if(mCursor !=null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor SelecteerStudenten1E(){
        String Table = "Studenten";
        String [] fields = {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS, KEY_GROEP};
        String where = "_klas = 'INF1E'";
        Cursor mCursor = mDB.query(Table, fields, where, null, null, null, null);
        if(mCursor !=null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor SelecteerStudenten1F(){
        String Table = "Studenten";
        String [] fields = {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS, KEY_GROEP};
        String where = "_klas = 'INF1F'";
        Cursor mCursor = mDB.query(Table, fields, where, null, null, null, null);
        if(mCursor !=null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor SelecteerStudenten1G(){
        String Table = "Studenten";
        String [] fields = {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS, KEY_GROEP};
        String where = "_klas = 'INF1G'";
        Cursor mCursor = mDB.query(Table, fields, where, null, null, null, null);
        if(mCursor !=null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor SelecteerStudenten1H(){
        String Table = "Studenten";
        String [] fields = {KEY_ROWID, KEY_NAAM, KEY_STUDENTNUMMER, KEY_KLAS, KEY_GROEP};
        String where = "_klas = 'INF1H'";
        Cursor mCursor = mDB.query(Table, fields, where, null, null, null, null);
        if(mCursor !=null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public void insertStudenten(){
        createStudent("Adel, Pieter", "s1078455", "INF1G", "2");
        createStudent("Bieber, Justin", "s1084567", "INF1D", "1");
        createStudent("Cornelissen, Frederik","s1089456", "INF1B", "2");
        createStudent("Dadel, Maria", "s1087499", "INF1F", "3");
        createStudent("Dekker, Vera", "s1084235", "INF1B", "1");
        createStudent("Elegast, Karel", "s1074211", "INF1E", "1");
        createStudent("Emmer, Lisa", "s1074326", "INF1C", "2");
        createStudent("Ezel, Merel", "s1089475", "INF1G", "3");
        createStudent("Hendriksen, Dorien", "s1074788", "INF1A", "3");
        createStudent("Krokus, Joke", "s1089413", "INF1H", "2");
        createStudent("Mandarijn, Max", "s1084211", "INF1H", "2");
        createStudent("Nelissen, Henk", "s1087465", "INF1F", "1");
        createStudent("Ober, Jan", "s1087455", "INF1F", "2");
        createStudent("Rokers, Lianne", "s1071244", "INF1G", "3");
        createStudent("Tekkel, Hester ", "s1071586", "INF1C", "1");
        createStudent("Uitjes, Berend ", "s1087451", "INF1A", "2");
        createStudent("Venkeltje, Sophia ", "s1075612", "INF1B", "2");
        createStudent("Vlieger, Olaf ", "s1074127", "INF1E", "2");
        createStudent("Vogel, Bas ", "s1084522", "INF1A", "1");
        createStudent("Water, Michiel ", "s1084531", "INF1H", "3");
        createStudent("Weken, Dirk ", "s1074537", "INF1D", "2");
        createStudent("Wieken, Stefanie ", "s1084511", "INF1C", "1");
        createStudent("Zeker, Donald ", "s1077369", "INF1E", "3");


    }
}
