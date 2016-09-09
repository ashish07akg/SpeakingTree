package com.example.ashish.speakingtree_android.http;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;

import java.net.URL;

/**
 * Created by Ashish on 8/25/2016.
 */
public class BaseAsyncTask extends AsyncTask<URL,Integer,ServerResponse> {

    protected  int statuscode;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected ServerResponse doInBackground(URL... params) {
        ServerResponse objResponse = RestFulWebServiceHelper.requestWebService(params[0]);
        return objResponse;
    }

}
