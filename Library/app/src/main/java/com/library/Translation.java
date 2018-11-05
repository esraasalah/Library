package com.library;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.library.R;

public class Translation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        ImageView  translation = (ImageView) findViewById(R.id.upload);
        Bitmap bitMap= BitmapFactory.decodeResource(getResources(),R.drawable.translation);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitMap);
        roundedBitmapDrawable.setCircular(true);
        translation.setImageDrawable(roundedBitmapDrawable);


    }


  public  void  goToPrintingFormat(View view)
  {

      startActivity(new Intent(getApplicationContext(),PrintingFormat.class));

  }




}
