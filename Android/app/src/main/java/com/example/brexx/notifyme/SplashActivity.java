package com.example.brexx.notifyme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//1st Screen for Splash and register selections


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firsttimexecute();
    }

    public void Firsttimexecute()
    {
        SharedPreferences settings=getSharedPreferences("prefs",0);
        boolean firstRun=settings.getBoolean("firstRun",false);
        if(firstRun==false)//if running for first time
        //Splash will load for first time
        {
            SharedPreferences.Editor editor=settings.edit();
            editor.putBoolean("firstRun",true);
            editor.commit();
            Intent i=new Intent(SplashActivity.this,RegisterActivity.class);
            startActivity(i);
            finish();
        }
        else
        {

            Intent a=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(a);
            finish();
        }
    }
}
