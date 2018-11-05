package com.library;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.library.R;

public class UploadFile extends AppCompatActivity {


    EditText urlEditText ;
      static String  url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);



        ImageView filePresentation = (ImageView) findViewById(R.id.upload);
        Bitmap bitMap= BitmapFactory.decodeResource(getResources(),R.drawable.upload);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitMap);
        roundedBitmapDrawable.setCircular(true);
        filePresentation.setImageDrawable(roundedBitmapDrawable);

        urlEditText = findViewById(R.id.url);
    }

    public void print (View view)
    {

         url=urlEditText.getText().toString();

        if ( url.length()>0) {
            Log.i("urllllllll",url);
            startActivity(new Intent(getApplicationContext(), DocumentFormat.class));

        }
        else

        {

            Toast.makeText(this,"please Enter document url",Toast.LENGTH_LONG).show();

        }

    }
}
