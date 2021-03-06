package com.example.ashish.speakingtree_android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity



                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
        new MyThread(new Handler()).start();
    }
/*
    public void GetData(){

        userModel usermodel= new userModel(this);
        usermodel=  usermodel.getUserDetail();
        if(usermodel!=null){

        }
    }*/
    class MyThread extends  Thread{
        Handler mHandler;
        Runnable m = new Runnable() {
            @Override
            public void run() {

            }
        };
        MyThread(Handler handler){
            mHandler = handler;
        }
        @Override
        public void run() {
            //t
           // GetData();
            mHandler.post(m);
        }

    }

}