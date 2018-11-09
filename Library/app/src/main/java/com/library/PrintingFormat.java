package com.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.library.R;

public class PrintingFormat extends AppCompatActivity {

    final String genders[] = { "Fininshing", "No finishing", "Binding", "Stapling" };
    TextView englishLang , arabicLang , a4Paper , a5Paper , blackAndWhite , colord , singleSide , doubleSide , price , quantity  ;

    String paperLanguage , paperType , paperColor , paperSide  , finish ,  paperQuantity , finalPrice  ;

    int langPrice =0 , paperPrice =0, colorPrice =0 , sidePrice =0, totalPrice =0, counter = 1;




    NumberPicker numberPicker1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printing_format);

        numberPicker1= (NumberPicker) findViewById(R.id.numberPicker1);


        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(genders.length - 1);
        numberPicker1.setDisplayedValues(genders);
        numberPicker1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        englishLang=findViewById(R.id.englishlanguage);
        arabicLang=findViewById(R.id.arabiclanguage);
        a4Paper=findViewById(R.id.a4paper);
        a5Paper=findViewById(R.id.a5paper);
        blackAndWhite=findViewById(R.id.blackandwhite);
        colord=findViewById(R.id.colord);
        singleSide=findViewById(R.id.singleside);
        doubleSide=findViewById(R.id.doubleside);
        price=findViewById(R.id.price);
        quantity=findViewById(R.id.quantity);



    }

    public void setTotalPrice ()
    {


        totalPrice = (langPrice+ paperPrice +colorPrice + sidePrice )* counter ;
        price.setText(String.valueOf(totalPrice));



    }

    public void selectPaymentMethod(View view)
    {
        Intent i = new Intent(getApplicationContext(),Payment.class);
        startActivity(i);
    }

     public void selectEngLang (View view)
     {

         englishLang.setBackgroundResource(R.drawable.blue_oval_button);
         arabicLang.setBackgroundResource(R.drawable.black_border_oval);
         langPrice=5;
         setTotalPrice();


     }


    public void selectarabicLang (View view)
    {

        arabicLang.setBackgroundResource(R.drawable.blue_oval_button);
        englishLang.setBackgroundResource(R.drawable.black_border_oval);

        langPrice=2;
        setTotalPrice();


    }


    public void selectA4Paper (View view)
    {

        a4Paper.setBackgroundResource(R.drawable.blue_oval_button);
        a5Paper.setBackgroundResource(R.drawable.black_border_oval);
        paperPrice=4;
        setTotalPrice();


    }
    public void selectA5Paper (View view)
    {

        a5Paper.setBackgroundResource(R.drawable.blue_oval_button);
        a4Paper.setBackgroundResource(R.drawable.black_border_oval);
        paperPrice=5;
        setTotalPrice();

    }

    public void selectBlackAndWhite (View view)
    {

        blackAndWhite.setBackgroundResource(R.drawable.blue_oval_button);
        colord.setBackgroundResource(R.drawable.black_border_oval);
        colorPrice=3;
        setTotalPrice();


    }


    public void selectColored (View view)
    {

        colord.setBackgroundResource(R.drawable.blue_oval_button);
        blackAndWhite.setBackgroundResource(R.drawable.black_border_oval);
        colorPrice=5;
        setTotalPrice();


    }

    public void selectSingleSide (View view)
    {

        singleSide.setBackgroundResource(R.drawable.blue_oval_button);
        doubleSide.setBackgroundResource(R.drawable.black_border_oval);
        sidePrice=3;
        setTotalPrice();


    }

    public void selectdoubleSide (View view)
    {

        doubleSide.setBackgroundResource(R.drawable.blue_oval_button);
        singleSide.setBackgroundResource(R.drawable.black_border_oval);
        sidePrice=5;
        setTotalPrice();


    }



    public  void pressPlus(View view)
    {

        counter++;

        quantity.setText(String.valueOf(counter));
        setTotalPrice();
    }

    public   void pressMins (View view)
    {

        counter--;
        quantity.setText(String.valueOf(counter));
        setTotalPrice();

    }








}
