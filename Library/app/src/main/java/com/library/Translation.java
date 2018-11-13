package com.library;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Translation extends AppCompatActivity {

    static String url;
    EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        ImageView translation = findViewById(R.id.upload);
        Bitmap bitMap= BitmapFactory.decodeResource(getResources(),R.drawable.translation);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitMap);
        roundedBitmapDrawable.setCircular(true);
        translation.setImageDrawable(roundedBitmapDrawable);

        urlEditText = findViewById(R.id.urledittext);


    }


  public  void  goToPrintingFormat(View view) {

      url = urlEditText.getText().toString();

      if (url.length() > 0) {
          Log.i("urllllllll", url);
          startActivity(new Intent(getApplicationContext(), TranslationFormat.class));

      } else

      {

          Toast.makeText(this, "please Enter document url", Toast.LENGTH_LONG).show();

      }

  }


}
