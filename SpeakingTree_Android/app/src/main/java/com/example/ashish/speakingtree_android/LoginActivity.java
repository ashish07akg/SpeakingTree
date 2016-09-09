package com.example.ashish.speakingtree_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ashish.speakingtree_android.Model.SignUpModel;
import com.example.ashish.speakingtree_android.Model.UserInfo;
import com.example.ashish.speakingtree_android.Utils.AppToast;
import com.example.ashish.speakingtree_android.Utils.GlobalClass;
import com.example.ashish.speakingtree_android.Utils.InputValidatorHelper;
import com.example.ashish.speakingtree_android.Utils.OnLoginSuccessListener;
import com.example.ashish.speakingtree_android.database.databasemodel.userModel;
import com.example.ashish.speakingtree_android.http.ApiIdentifier;
import com.example.ashish.speakingtree_android.http.CustomAsyncTask;
import com.example.ashish.speakingtree_android.http.OnAsyncTaskHandler;
import com.example.ashish.speakingtree_android.http.UrlConfiq;
import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity implements OnAsyncTaskHandler {

    EditText txtEmail, txtPassword;
    Button btnLogin;
    String strLoginUrl = "";
    private  OnLoginSuccessListener mOnLoginTaskHandler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmail = (EditText) this.findViewById(R.id.txtEmail);
        txtPassword = (EditText) this.findViewById(R.id.txtPassword);
        btnLogin = (Button) this.findViewById(R.id.btnSignUp);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValidate()) {
                    strLoginUrl = String.format(UrlConfiq.LoginUrl, txtEmail.getText().toString(), txtPassword.getText().toString());
                    if (!strLoginUrl.isEmpty() && strLoginUrl != null) {
                        try {
                            URL urlToRequest = new URL(strLoginUrl);
                            CustomAsyncTask asyncTask = new CustomAsyncTask(v.getContext(), ApiIdentifier.Login_API, true);
                            asyncTask.setOnAsyncTaskHandler(LoginActivity.this);
                            asyncTask.execute(urlToRequest);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public boolean isInputValidate() {
        InputValidatorHelper inputValidatorHelper = new InputValidatorHelper();
        ;
        //Validate and Save
        boolean allowSave = true;
        if (!inputValidatorHelper.isValidEmail(txtEmail.getText().toString().trim())) {
            Toast.makeText(this, "Invalid email address.\n", Toast.LENGTH_LONG).show();
            allowSave = false;
            txtEmail.requestFocus();


        } else if (inputValidatorHelper.isNullOrEmpty(txtPassword.getText().toString().trim())) {
            Toast.makeText(this, "Password should not be empty.\n", Toast.LENGTH_LONG).show();
            allowSave = false;
            txtPassword.requestFocus();
            return allowSave;
        }
        return allowSave;
    }

    @Override
    public void onSuccess(int requestId, String response) {
        String strResponse = response;
        Log.e("Success: ", strResponse);
        Gson objGson = new Gson();
        UserInfo objUser = objGson.fromJson(strResponse, UserInfo.class);
        if (objUser != null) {


            userModel usermodel = new userModel(this);
            usermodel.setLogin_HashMap(objUser.getLoginhash());
            if (objUser.getUser() != null) {
                usermodel.setUser_Name(objUser.getUser().getName());
                usermodel.setLogin_HashMap(objUser.getLoginhash());
                usermodel.setUser_Gender(objUser.getUser().getGender());
                usermodel.setUser_Followers(objUser.getUser().getFollowers());
                usermodel.setUser_ID(objUser.getUser().getUserid()
                );
                usermodel.setUser_thumbImage(objUser.getUser().getThumbnail());
                usermodel.setUser_WapImage(objUser.getUser().getWapimage());
                usermodel.setUser_Biography(objUser.getUser().getBiography());
                usermodel.setUser_Role(objUser.getUser().getUserrole());
                usermodel.setUSER_DOB(objUser.getUser().getDob());
                long result = usermodel.insertUserDetail(usermodel);


                // Calling Application class (see application tag in AndroidManifest.xml)
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                //Set name and email in global/application context
                globalVariable.setName(usermodel.getUser_Name());
                globalVariable.setLoginhash(usermodel.getLogin_HashMap());
                globalVariable.setImagethumb(usermodel.getUser_thumbImage());
                Intent goToMainActivity = new Intent(this,HomeActivity.class);;
                goToMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Will clear out your activity history stack till now
                startActivity(goToMainActivity);


            }
        }
        else {

            if(objUser.getResult().equals("error"))
                {
            AppToast.showToast(this,"Something wrong . please try again");
                }
        }

    }


    public void setOnisLoginkHandler(OnLoginSuccessListener onisLoginkHandler){
        mOnLoginTaskHandler = onisLoginkHandler ;
    }

    @Override
    public void onFailure(int requestId, String response) {
        Log.e("Failure: ", response);
        Gson objGson = new Gson();
        SignUpModel objSignUp = objGson.fromJson(response, SignUpModel.class);
        if (objSignUp != null) {
            if (!objSignUp.getResult().isEmpty())
            {
                mOnLoginTaskHandler.onSuccess(false);
                AppToast.showToast(this, objSignUp.getError());
            }
        }


    }


}
