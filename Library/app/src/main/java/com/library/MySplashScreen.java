package com.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.library.R;

public class MySplashScreen extends AppCompatActivity {


    private Intent i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_splash_screen);

        i = new Intent(getBaseContext(), MainActivity.class);
        splashScreen(100);


    }


    public void splashScreen (final int x)
    {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(i);
                finish();
            }
        }).start();
    }



}
