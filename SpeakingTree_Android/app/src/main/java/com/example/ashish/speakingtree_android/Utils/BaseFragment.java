package com.example.ashish.speakingtree_android.Utils;

import android.support.v4.app.Fragment;

import com.android.volley.VolleyError;
import com.example.ashish.speakingtree_android.http.OnApiResponseListener;
import com.example.ashish.speakingtree_android.http.OnLoaderHandle;

/**
 * Created by Ashish on 8/11/2016.
 */
public class BaseFragment extends Fragment implements OnApiResponseListener, OnLoaderHandle {
    @Override
    public void onSuccess(Object response, int requestId) {
        onLoaderDismiss();
    }

    @Override
    public void onFailure(VolleyError error, int requestId) {
        onLoaderDismiss();
    }

    @Override
    public void onStart(int requestId) {
        onLoaderStart();
    }

    @Override
    public void onLoaderStart() {

    }

    @Override
    public void onLoaderDismiss() {

    }
}
