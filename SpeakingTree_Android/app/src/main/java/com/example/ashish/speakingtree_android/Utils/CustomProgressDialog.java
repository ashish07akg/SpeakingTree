package com.example.ashish.speakingtree_android.Utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Ashish on 8/25/2016.
 */
public class CustomProgressDialog {

    private ProgressDialog progressDialog ;

    public void startDialog(Context context){
        if(progressDialog == null){
            progressDialog= new ProgressDialog(context);
            progressDialog.setTitle("Loading");
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Please wait");
        }
        progressDialog.show();
    }

    public void startDialogWithMsg(Context context,String title,String msg){
        if(progressDialog == null){
            progressDialog= new ProgressDialog(context);
            progressDialog.setTitle(title);
            progressDialog.setCancelable(false);
            progressDialog.setMessage(msg);
        }
        progressDialog.show();
    }

    public void dismissDialog(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

}
