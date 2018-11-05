package com.library;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.library.R;

public class OrderStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        ImageView one = (ImageView) findViewById(R.id.imageView20);
        Bitmap bitMap= BitmapFactory.decodeResource(getResources(),R.drawable.one);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitMap);
        roundedBitmapDrawable.setCircular(true);
        one.setImageDrawable(roundedBitmapDrawable);


        ImageView two = (ImageView) findViewById(R.id.imageView21);
        Bitmap bitMap2= BitmapFactory.decodeResource(getResources(),R.drawable.two);
        RoundedBitmapDrawable roundedBitmapDrawable2 = RoundedBitmapDrawableFactory.create(getResources(),bitMap2);
        roundedBitmapDrawable2.setCircular(true);
        two.setImageDrawable(roundedBitmapDrawable2);


        ImageView three = (ImageView) findViewById(R.id.imageView22);
        Bitmap bitMap3= BitmapFactory.decodeResource(getResources(),R.drawable.three);
        RoundedBitmapDrawable roundedBitmapDrawable3 = RoundedBitmapDrawableFactory.create(getResources(),bitMap3);
        roundedBitmapDrawable3.setCircular(true);
        three.setImageDrawable(roundedBitmapDrawable3);


    }
}
