package com.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DocumentFormat extends AppCompatActivity {

    static Orders myOrder = new Orders();
    static int totalPrice = 0;
    final String genders[]={ "No finishing", "Finishing", "Binding", "Stapling" };
    public int paperPrice = 0, colorPrice = 0, sidePrice = 0, counter = 1, finishingPrice = 0;
    FirebaseUser user;
    FirebaseAuth auth;
    TextView  a4Paper , a5Paper , blackAndWhite , colord , singleSide , doubleSide , price , quantity  ;
    String paperType , paperColor , paperSide  , finish ,  paperQuantity , finalPrice  ;
    NumberPicker numberPicker1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_format);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        numberPicker1 = findViewById(R.id.numberPicker1);

        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(genders.length - 1);
        numberPicker1.setDisplayedValues(genders);
        numberPicker1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);




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


        totalPrice = ( paperPrice +colorPrice + sidePrice + finishingPrice )* counter ;
        price.setText(String.valueOf(totalPrice));
        finalPrice=String.valueOf(totalPrice);



    }

    public void selectA4Paper (View view)
    {

        a4Paper.setBackgroundResource(R.drawable.blue_oval_button);
        a5Paper.setBackgroundResource(R.drawable.black_border_oval);
        paperPrice=4;
        paperType="A4";
        setTotalPrice();


    }
    public void selectA5Paper (View view)
    {

        a5Paper.setBackgroundResource(R.drawable.blue_oval_button);
        a4Paper.setBackgroundResource(R.drawable.black_border_oval);
        paperPrice=5;
        paperType="A5";
        setTotalPrice();

    }

    public void selectBlackAndWhite (View view)
    {

        blackAndWhite.setBackgroundResource(R.drawable.blue_oval_button);
        colord.setBackgroundResource(R.drawable.black_border_oval);
        colorPrice=3;
        paperColor="black and white";
        setTotalPrice();


    }


    public void selectColored (View view)
    {

        colord.setBackgroundResource(R.drawable.blue_oval_button);
        blackAndWhite.setBackgroundResource(R.drawable.black_border_oval);
        colorPrice=5;
        paperColor="colored";
        setTotalPrice();


    }

    public void selectSingleSide (View view)
    {

        singleSide.setBackgroundResource(R.drawable.blue_oval_button);
        doubleSide.setBackgroundResource(R.drawable.black_border_oval);
        sidePrice=3;
        paperSide="single";
        setTotalPrice();


    }

    public void selectdoubleSide (View view)
    {

        doubleSide.setBackgroundResource(R.drawable.blue_oval_button);
        singleSide.setBackgroundResource(R.drawable.black_border_oval);
        sidePrice=5;
        paperSide="double";
        setTotalPrice();


    }



    public  void pressPlus(View view)
    {

        counter++;

        quantity.setText(String.valueOf(counter));
        paperQuantity=String.valueOf(counter);
        setTotalPrice();
    }

    public   void pressMins (View view)
    {

        counter--;
        quantity.setText(String.valueOf(counter));
        paperQuantity=String.valueOf(counter);
        setTotalPrice();

    }

    public void finish()
    {

        finish = genders[numberPicker1.getValue()];

        int index=numberPicker1.getValue();
          if ( index == 1)
          {
              finishingPrice = 2 ;
              setTotalPrice();

          }
          else if(index == 2)
          {
              finishingPrice = 3 ;
              setTotalPrice();

          }
          else if (index == 3)
          {

              finishingPrice = 5 ;
              setTotalPrice();

          }



    }

    public void addToCart(View view)
    {

        UserHomeActivity.flag = 1;

        finish();

        if (paperType != null && paperColor != null && paperSide !=null )


        {
              if (counter >= 0) {

                  myOrder.setPaperType(paperType);
                  myOrder.setColor(paperColor);
                  myOrder.setSide(paperSide);
                  myOrder.setFinishing(finish);
                  myOrder.setNumberOfPages(paperQuantity);
                  myOrder.setPrice(finalPrice);
                  myOrder.setUrl(UploadFile.url);
                  myOrder.setType("printing");
                  myOrder.setEmail(user.getEmail());



                  Intent i = new Intent(getApplicationContext(), OrderInformation.class);
                  startActivity(i);
              }

              else {

                  Toast.makeText(this,"paper quantitiy cann't be less than 1", Toast.LENGTH_LONG).show();
              }

        }

        else {


            Toast.makeText(this,"please complete the choises", Toast.LENGTH_LONG).show();

        }


    }





}
