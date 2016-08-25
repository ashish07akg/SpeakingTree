package com.example.ashish.speakingtree_android.http;

/**
 * Created by Ashish on 8/11/2016.
 */
public class ApiUrl {
    public static String getUrl(int id){
        switch (id){
            case ApiIdentifier.FIRST_API:
                return UrlConfiq.HomeUrl ;
            default:
                return null ;
        }
    }
}
