package com.example.ashish.speakingtree_android.http;

/**
 * Created by Ashish on 8/25/2016.
 */
public interface OnAsyncTaskHandler {
    void onSuccess(int requestId, String response);
    void onFailure(int requestId, String response);
}
