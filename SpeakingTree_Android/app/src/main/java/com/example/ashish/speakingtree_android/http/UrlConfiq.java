package com.example.ashish.speakingtree_android.http;

/**
 * Created by Ashish on 8/10/2016.
 */
public  class UrlConfiq {
    //URL of my Home API
    public static  String HomeUrl = "http://www.speakingtree.in/app/home.php";
    public static  String RegistrationUrl = "http://www.speakingtree.in/app/reg.php?fname=%s&lname=%s&email=%s&password=%s&cpassword=%s";
    public static  String MasterListUrl ="http://www.speakingtree.in/app/userlist.php?page=%03d&type=%s&limit=%s&filter=%s";
    public static  String LoginUrl =  "http://www.speakingtree.in/app/login.php?email=%s&password=%s";
}
