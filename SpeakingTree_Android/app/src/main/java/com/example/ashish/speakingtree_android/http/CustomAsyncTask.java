package com.example.ashish.speakingtree_android.http;

import android.content.Context;
import android.text.TextUtils;

import com.example.ashish.speakingtree_android.Utils.CustomProgressDialog;

/**
 * Created by Ashish on 8/25/2016.
 */
public class CustomAsyncTask extends BaseAsyncTask {
    private final CustomProgressDialog mCustomProgressDialog;
    private int mRequestId ;
    private  OnAsyncTaskHandler mOnAsyncTaskHandler ;
    private Context mContext;

    public CustomAsyncTask (Context context,int requestId){
        mRequestId = requestId ;
        mCustomProgressDialog = new CustomProgressDialog();
        mContext = context ;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCustomProgressDialog.startDialog(mContext);
    }

    @Override
    protected void onPostExecute(String outputresult) {
        super.onPostExecute(outputresult);
        mCustomProgressDialog.dismissDialog();
        if(!TextUtils.isEmpty(outputresult)){
            mOnAsyncTaskHandler.onSuccess(mRequestId,outputresult);
        }else{
            mOnAsyncTaskHandler.onFailure(mRequestId,outputresult);
        }
    }

    public void setOnAsyncTaskHandler(OnAsyncTaskHandler onAsyncTaskHandler){
        mOnAsyncTaskHandler = onAsyncTaskHandler ;
    }
}
