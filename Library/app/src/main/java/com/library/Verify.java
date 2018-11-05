package com.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.library.R;

public class Verify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
    }

    public void verify(View view){

        if (MainActivity.flag == 1) {

            Intent i = new Intent(getApplicationContext(), AdminHomeActivity.class);
            startActivity(i);
        }
        else if (MainActivity.flag == 2) {


            Intent i = new Intent(getApplicationContext(), UserHomeActivity.class);
            startActivity(i);

        }

    }



}
