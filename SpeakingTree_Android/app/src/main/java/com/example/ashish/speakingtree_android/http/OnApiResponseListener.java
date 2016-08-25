package com.example.ashish.speakingtree_android.http;

import com.android.volley.VolleyError;

/**
 * Created by Ashish on 8/11/2016.
 */
public interface OnApiResponseListener {
    void onSuccess(Object response, int requestId);
    void onFailure(VolleyError error, int requestId);
    void onStart(int requestId);
}
