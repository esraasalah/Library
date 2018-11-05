package com.library;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;

import com.library.R;

public class MainActivity extends AppCompatActivity {
    public  static int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set admin~Image rounded
        ImageView admin = (ImageView) findViewById(R.id.imageView6);
        Bitmap bitMap= BitmapFactory.decodeResource(getResources(),R.drawable.admin);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitMap);
        roundedBitmapDrawable.setCircular(true);
        admin.setImageDrawable(roundedBitmapDrawable);


        //set studentImage rounded
        ImageView student= (ImageView) findViewById(R.id.imageView7);
        Bitmap bitMap2= BitmapFactory.decodeResource(getResources(),R.drawable.student);
        RoundedBitmapDrawable roundedBitmapDrawable2 = RoundedBitmapDrawableFactory.create(getResources(),bitMap2);
        roundedBitmapDrawable2.setCircular(true);
        student.setImageDrawable(roundedBitmapDrawable2);

    }
     public void loginOrRegisterAdmin(View view)
     {


         flag = 1;
         Intent i = new Intent(getApplicationContext(), Login.class);
         startActivity(i);


     }

     public void loginOrRegisterStudent(View view)
     {


         flag = 2;
         Intent i = new Intent(getApplicationContext(),LoginOrRegister.class);
         startActivity(i);


     }






}
