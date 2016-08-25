package com.example.ashish.speakingtree_android.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Ashish on 8/25/2016.
 */
public class AppToast {
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
