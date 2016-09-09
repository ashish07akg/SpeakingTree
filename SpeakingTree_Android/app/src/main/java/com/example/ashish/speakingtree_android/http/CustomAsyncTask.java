package com.example.ashish.speakingtree_android.http;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
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
    private Boolean misLoader;


    public CustomAsyncTask (Context context,int requestId,Boolean isLoader){
        mRequestId = requestId ;
        mCustomProgressDialog = new CustomProgressDialog();
        mContext = context ;
        misLoader=isLoader;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(misLoader==true)
        mCustomProgressDialog.startDialog(mContext);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onPostExecute(ServerResponse serverResponse) {
        super.onPostExecute(serverResponse);
        String outputresult=serverResponse.getResponse();
      //  if(statuscode==201 || statuscode==200)
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
