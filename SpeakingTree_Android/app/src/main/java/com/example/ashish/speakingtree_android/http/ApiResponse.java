package com.example.ashish.speakingtree_android.http;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ashish on 8/11/2016.
 */
public class ApiResponse implements Response.Listener , Response.ErrorListener {

    private final int requestId;
    private final Context mContext ;

    public ApiResponse (Context context,int requestId){
        this.requestId = requestId;
        this.mContext = context ;
    }

    public void makeRequest(){
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonObjectRequest obreq = new JsonObjectRequest(ApiUrl.getUrl(requestId),null,this,this);
        requestQueue.add(obreq);
    }

    private OnApiResponseListener mOnApiResponseListener;

    @Override
    public void onResponse(Object response) {
        if(mOnApiResponseListener == null ) return;
        mOnApiResponseListener.onSuccess(response,requestId);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if(mOnApiResponseListener == null ) return;
        mOnApiResponseListener.onFailure(error,requestId);
        Log.e("Error",error.toString());
    }

    public void setOnApiResponseListener(OnApiResponseListener onApiResponseListener){
        mOnApiResponseListener = onApiResponseListener ;
    }
}
