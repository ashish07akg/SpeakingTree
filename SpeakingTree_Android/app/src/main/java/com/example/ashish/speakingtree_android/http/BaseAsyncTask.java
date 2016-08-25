package com.example.ashish.speakingtree_android.http;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.net.URL;

/**
 * Created by Ashish on 8/25/2016.
 */
public class BaseAsyncTask extends AsyncTask<URL,Integer,String> {


    @Override
    protected String doInBackground(URL... params) {

        String outputResponse="";
        int counturl=params.length;
        for(int i=0;i<counturl;i++){
            JSONObject objResponse= RestFulWebServiceHelper.requestWebService(params[i]);
            if(objResponse!=null)
            Log.e("Response Data :" , objResponse.toString());
            outputResponse=objResponse.toString();
        }

        return outputResponse;
    }

}
