package com.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.library.R;

public class PresentationFormat extends AppCompatActivity {


    int counter = 1 , totalPrice;
    TextView numberOfSlides , price ;
    EditText email ;
    Button plus , mins ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_format);

        numberOfSlides=findViewById(R.id.numberofslides);
        price = findViewById(R.id.price);
        email=findViewById(R.id.email);
        plus= findViewById(R.id.plus);
        mins=findViewById(R.id.mins);



    }

    public void setTotalPrice ()
    {


        totalPrice = 2* counter ;
        price.setText(String.valueOf(totalPrice));



    }

    public  void pressPlus(View view)
    {

        counter++;

        numberOfSlides.setText(String.valueOf(counter));
        setTotalPrice();
    }

    public   void pressMins (View view)
    {

        counter--;
        numberOfSlides.setText(String.valueOf(counter));
        setTotalPrice();

    }


    public void selectPaymentMethod(View view)
    {
        Intent i = new Intent(getApplicationContext(),Payment.class);
        startActivity(i);
    }



}
