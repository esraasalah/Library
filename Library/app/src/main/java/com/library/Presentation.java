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

public class Presentation extends AppCompatActivity {


    static String url;
    EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        ImageView Presentation = findViewById(R.id.upload);
        Bitmap bitMap= BitmapFactory.decodeResource(getResources(),R.drawable.presentation);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitMap);
        roundedBitmapDrawable.setCircular(true);
        Presentation.setImageDrawable(roundedBitmapDrawable);
        urlEditText = findViewById(R.id.urledittext);




    }

    public void printPresentation (View view)
    {


        url = urlEditText.getText().toString();

        if (url.length() > 0) {
            Log.i("urllllllll", url);
            startActivity(new Intent(getApplicationContext(), PresentationFormat.class));

        } else

        {

            Toast.makeText(this, "please Enter presentation url", Toast.LENGTH_LONG).show();

        }


    }
}
