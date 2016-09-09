package com.example.ashish.speakingtree_android.database;

/**
 * Created by Ashish on 9/2/2016.
 */
public class tableStructure {

    // User table create statement
    public static final String CREATE_TABLE_User = "CREATE TABLE "

            + dbUserModel.TABLE_USER + "("
            + dbUserModel.User_ID + " INTEGER PRIMARY KEY,"
            + dbUserModel.Login_HashMap + " TEXT,"
            + dbUserModel.User_Biography + " TEXT,"
            + dbUserModel.User_Dob + " Text,"
            + dbUserModel.User_Gender + " Text,"
            + dbUserModel.User_thumbImage + " Text,"
            + dbUserModel.User_WapImage + " Text,"
            + dbUserModel.User_Followers + " Text,"
            + dbUserModel.User_Name + " Text,"
            + dbUserModel.User_Role + " Text" + ")";


}
