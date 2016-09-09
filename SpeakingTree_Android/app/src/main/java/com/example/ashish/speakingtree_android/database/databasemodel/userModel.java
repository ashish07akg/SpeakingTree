package com.example.ashish.speakingtree_android.database.databasemodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ashish.speakingtree_android.database.SqLiteDatabaseHelper;
import com.example.ashish.speakingtree_android.database.dbUserModel;

/**
 * Created by Ashish on 9/2/2016.
 */
public class userModel {



    // Common column names
    int id;
    String User_ID;
    String User_Role;
    String User_Name;
    String Login_HashMap;
    String User_Followers;
    String User_Gender;
    String USER_DOB;
    String User_thumbImage;
    String User_WapImage;
    String User_Biography;
    Context mcontext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_Role() {
        return User_Role;
    }

    public void setUser_Role(String user_Role) {
        User_Role = user_Role;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getLogin_HashMap() {
        return Login_HashMap;
    }

    public void setLogin_HashMap(String login_HashMap) {
        Login_HashMap = login_HashMap;
    }

    public String getUser_Followers() {
        return User_Followers;
    }

    public void setUser_Followers(String user_Followers) {
        User_Followers = user_Followers;
    }

    public String getUser_Gender() {
        return User_Gender;
    }

    public void setUser_Gender(String user_Gender) {
        User_Gender = user_Gender;
    }

    public String getUSER_DOB() {
        return USER_DOB;
    }

    public void setUSER_DOB(String USER_DOB) {
        this.USER_DOB = USER_DOB;
    }

    public String getUser_thumbImage() {
        return User_thumbImage;
    }

    public void setUser_thumbImage(String user_thumbImage) {
        User_thumbImage = user_thumbImage;
    }

    public String getUser_WapImage() {
        return User_WapImage;
    }

    public void setUser_WapImage(String user_WapImage) {
        User_WapImage = user_WapImage;
    }

    public String getUser_Biography() {
        return User_Biography;
    }

    public void setUser_Biography(String user_Biography) {
        User_Biography = user_Biography;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }

    private SqLiteDatabaseHelper dbHelper;
    public userModel(Context context) {
        mcontext=context;
        dbHelper=new SqLiteDatabaseHelper(context);

           }


    public long insertUserDetail(userModel userdeatail) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbUserModel.User_ID, userdeatail.getUser_ID());
        values.put(dbUserModel.Login_HashMap, userdeatail.getLogin_HashMap());
        values.put(dbUserModel.User_Name, userdeatail.getUser_Name());
        values.put(dbUserModel.User_Biography, userdeatail.getUser_Biography());
        values.put(dbUserModel.User_Gender, userdeatail.getUser_Gender());
        values.put(dbUserModel.User_thumbImage, userdeatail.getUser_thumbImage());
        values.put(dbUserModel.User_WapImage, userdeatail.getUser_WapImage());
        values.put(dbUserModel.User_Role, userdeatail.getUser_Role());
        values.put(dbUserModel.User_Dob, userdeatail.getUSER_DOB());
        values.put(dbUserModel.User_Followers, userdeatail.getUser_Followers());
        // insert row
        long todo_id = db.insert(dbUserModel.TABLE_USER, null, values);
        return todo_id;
    }


    public userModel getUserDetail() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + dbUserModel.TABLE_USER ;
        Log.e("Log", selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
       userModel usermodel = new userModel(mcontext);
        usermodel.setUser_ID(c.getString(c.getColumnIndex(dbUserModel.User_ID)));
        usermodel.setUser_Name((c.getString(c.getColumnIndex(dbUserModel.User_Name))));
        usermodel.setUser_Biography(c.getString(c.getColumnIndex(dbUserModel.User_Biography)));
        usermodel.setLogin_HashMap(c.getString(c.getColumnIndex(dbUserModel.Login_HashMap)));
        usermodel.setUser_thumbImage((c.getString(c.getColumnIndex(dbUserModel.User_thumbImage))));
        usermodel.setUser_WapImage(c.getString(c.getColumnIndex(dbUserModel.User_WapImage)));
        return usermodel;
    }

    public int updateToDo(userModel userdeatail) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbUserModel.User_ID, userdeatail.getUser_ID());
        values.put(dbUserModel.Login_HashMap, userdeatail.getLogin_HashMap());
        values.put(dbUserModel.User_Name, userdeatail.getUser_Name());
        values.put(dbUserModel.User_Biography, userdeatail.getUser_Biography());
        values.put(dbUserModel.User_Gender, userdeatail.getUser_Gender());
        values.put(dbUserModel.User_thumbImage, userdeatail.getUser_thumbImage());
        values.put(dbUserModel.User_WapImage, userdeatail.getUser_WapImage());
        values.put(dbUserModel.User_Role, userdeatail.getUser_Role());
        values.put(dbUserModel.User_Dob, userdeatail.getUSER_DOB());
        values.put(dbUserModel.User_Followers, userdeatail.getUser_Followers());
        // updating row
        return db.update(dbUserModel.TABLE_USER, values, dbUserModel.User_ID + " = ?",
                new String[] { String.valueOf(userdeatail.getUser_ID()) });
    }







}
