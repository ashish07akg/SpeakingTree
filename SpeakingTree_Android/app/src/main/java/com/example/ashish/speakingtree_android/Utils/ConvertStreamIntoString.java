package com.example.ashish.speakingtree_android.Utils;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Ashish on 8/31/2016.
 */
public class ConvertStreamIntoString {
    public static String getResponseText(InputStream inStream) {
        // http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html
        return new Scanner(inStream).useDelimiter("\\A").next();
    }
}
