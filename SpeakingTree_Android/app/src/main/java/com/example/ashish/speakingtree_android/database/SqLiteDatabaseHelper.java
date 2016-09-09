package com.example.ashish.speakingtree_android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ashish on 9/2/2016.
 */
public class SqLiteDatabaseHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "dbspeakingTree";
    private SqLiteDatabaseHelper myDbHelper;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    public SqLiteDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

   /* public SqLiteDatabaseHelper getInstance(Context context){
        if(myDbHelper==null)
        {
            return  myDbHelper= new SqLiteDatabaseHelper(context);
        }
        else{
            return  myDbHelper;
        }

    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(tableStructure.CREATE_TABLE_User);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + tableStructure.CREATE_TABLE_User);
    }


    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
