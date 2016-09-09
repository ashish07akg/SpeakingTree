package com.example.ashish.speakingtree_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashish.speakingtree_android.Enum.SignUpResponse;
import com.example.ashish.speakingtree_android.Model.SignUpModel;
import com.example.ashish.speakingtree_android.Utils.AppToast;
import com.example.ashish.speakingtree_android.Utils.InputValidatorHelper;
import com.example.ashish.speakingtree_android.http.ApiIdentifier;
import com.example.ashish.speakingtree_android.http.CustomAsyncTask;
import com.example.ashish.speakingtree_android.http.OnAsyncTaskHandler;
import com.example.ashish.speakingtree_android.http.UrlConfiq;
import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;

public class SignupActivity extends AppCompatActivity implements OnAsyncTaskHandler {

    EditText txtFirstname,txtLastname,txtEmail,txtPassword,txtRepasswprd;
    Button btnSignUp;
    String strUrl;
    String strResponse;
    TextView tvSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtFirstname = (EditText) this.findViewById(R.id.txtFirstname);
        txtLastname = (EditText) this.findViewById(R.id.txtLastname);
        txtEmail = (EditText) this.findViewById(R.id.txtEmail);
        txtPassword = (EditText) this.findViewById(R.id.txtPassword);
        txtRepasswprd = (EditText) this.findViewById(R.id.txtReenterpassword);
        btnSignUp = (Button) this.findViewById(R.id.btnSignUp);
        tvSign=(TextView)this.findViewById(R.id.tvSign) ;
        tvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignIn = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intentSignIn);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if( isInputValidate())
              {
                  strUrl= String.format(UrlConfiq.RegistrationUrl,txtFirstname.getText().toString(),txtLastname.getText().toString(),txtEmail.getText().toString(),txtPassword.getText().toString(),txtRepasswprd.getText().toString());

                  if(!strUrl.isEmpty() && strUrl!=null)
                  {
                      try {
                          URL urlToRequest = new URL(strUrl);
                          CustomAsyncTask asyncTask = new CustomAsyncTask(v.getContext(), ApiIdentifier.SIGNUP_API,false);
                          asyncTask.setOnAsyncTaskHandler(SignupActivity.this);
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
        InputValidatorHelper inputValidatorHelper = new InputValidatorHelper();       ;
        //Validate and Save
        boolean allowSave = true;
        if (inputValidatorHelper.isNullOrEmpty(txtFirstname.getText().toString().trim())) {
            AppToast.showToast(this,"First name should not be empty.\n");
            allowSave = false;
            txtFirstname.requestFocus();
            return allowSave;
        }
        else if (inputValidatorHelper.isNullOrEmpty(txtLastname.getText().toString().trim())) {

            Toast.makeText(this, "Last name should not be empty.\n", Toast.LENGTH_LONG).show();
            allowSave = false;
            txtLastname.requestFocus();
            return allowSave;
        }
        else if (!inputValidatorHelper.isValidEmail(txtEmail.getText().toString().trim())) {
            Toast.makeText(this, "Invalid email address.\n", Toast.LENGTH_LONG).show();
            allowSave = false;
            txtEmail.requestFocus();
            return allowSave;
        }
       else if (inputValidatorHelper.isNullOrEmpty(txtPassword.getText().toString().trim())) {
            Toast.makeText(this, "Password should not be empty.\n", Toast.LENGTH_LONG).show();
            allowSave = false;
            txtPassword.requestFocus();
            return allowSave;
        }
        else if (inputValidatorHelper.isNullOrEmpty(txtRepasswprd.getText().toString().trim())) {

            Toast.makeText(this, "Re-enter Password should not be empty.\n", Toast.LENGTH_LONG).show();
            allowSave = false;
            txtRepasswprd.requestFocus();
            return allowSave;
        }
        else if(!inputValidatorHelper.isPasswordMatching(txtPassword.getText().toString().trim(),txtRepasswprd.getText().toString().trim()))
        {
            Toast.makeText(this, "passwords are not match", Toast.LENGTH_LONG).show();
            allowSave = false;
            txtRepasswprd.requestFocus();
            return allowSave;
        }
        return  allowSave;

    }

    @Override
    public void onSuccess(int requestId, String response) {
        strResponse=response;
        Log.e("Success: " ,strResponse);
        Gson objGson= new Gson();
        SignUpModel objSignUp=objGson.fromJson(strResponse,SignUpModel.class);
        if(objSignUp!=null)
        {
            if(!objSignUp.getResult().toString().isEmpty()){
            if (objSignUp.getResult().toString().equals(SignUpResponse.success.toString())) {

                AppToast.showToast(this, "You have registered successfully");
                Intent intentSignIn = new Intent(this, LoginActivity.class);
                startActivity(intentSignIn);
                finish();
            } else {
                AppToast.showToast(this, objSignUp.getError().toString());
            }
        }
        }
        else
        {
            AppToast.showToast(this,"Server Problem");
        }
    }

    @Override
    public void onFailure(int requestId, String response) {
        strResponse=response;
        Log.e("Failure: " ,strResponse);
    }
}
