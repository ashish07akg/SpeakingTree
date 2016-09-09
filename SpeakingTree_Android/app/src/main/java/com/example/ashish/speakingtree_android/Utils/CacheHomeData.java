package com.example.ashish.speakingtree_android.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ashish on 8/24/2016.
 */
public class CacheHomeData {

    private static CacheHomeData homeprefernce;
    public SharedPreferences sharedPreferences;

    public static  CacheHomeData getInstance(Context context) {
        if(homeprefernce==null)
        {
            homeprefernce= new CacheHomeData(context);
        }
        return  homeprefernce;
    }
        private CacheHomeData (Context context)
        {
            sharedPreferences=context.getSharedPreferences("HomeData",Context.MODE_PRIVATE);
        }

    public void SaveData(String key,String value) {
        SharedPreferences.Editor prefrenceEditor= sharedPreferences.edit();
        prefrenceEditor.putString(key,value);
        prefrenceEditor.commit();
    }

    public String GetData(String Key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(Key, "");
        }
        return "";

    }


}
