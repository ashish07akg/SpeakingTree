package com.example.ashish.speakingtree_android.Utils;

import android.app.Application;

/**
 * Created by Ashish on 9/3/2016.
 */
public class GlobalClass  extends Application{

    private String name;
    private String loginhash;
    private String userImage;


    public String getName() {

        return name;
    }

    public void setName(String aName) {

        name = aName;

    }

    public String getLoginhash() {

        return loginhash;
    }

    public void setLoginhash(String aEmail) {

        loginhash = aEmail;
    }


    public String getImagethumb() {

        return userImage;
    }

    public void setImagethumb(String aEmail) {

        userImage = aEmail;
    }

}
