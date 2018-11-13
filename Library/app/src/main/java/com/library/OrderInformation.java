package com.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class OrderInformation extends AppCompatActivity {

    TextView color, type, quantity, side, finish, url, note;

    TextView printingFee ;

    String userNameT="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_information);


        printingFee=findViewById(R.id.printingfee);
        color=findViewById(R.id.color);
        type=findViewById(R.id.type);
        quantity=findViewById(R.id.quantity);
        side=findViewById(R.id.side);
        finish=findViewById(R.id.finish);
        note = findViewById(R.id.notes);
        url = findViewById(R.id.url);


        showDetails();



        Log.i("loggggggggg",userNameT);





    }

     public void getOrderState (View view)
     {

         Intent i = new Intent(getApplicationContext() , OrderStatus.class);
         startActivity(i);
     }

     public void  edit (View view)
     {

         startActivity(new Intent(getApplicationContext() , DocumentFormat.class));


     }

    public void  delete (View view)
    {

        startActivity(new Intent(getApplicationContext() , DocumentFormat.class));


    }

    public void selectPaymentMethod(View view)
    {
        Intent i = new Intent(getApplicationContext(),Payment.class);
        startActivity(i);
    }

    public  void delivery ()
    {

        Intent i = new Intent(getApplicationContext(),OrderStatus.class);
        startActivity(i);


    }

    public void showDetails() {

        if (UserHomeActivity.flag == 1) {

            printingFee.setText(String.valueOf(DocumentFormat.myOrder.getPrice()));
            color.setText(DocumentFormat.myOrder.getColor());
            finish.setText(DocumentFormat.myOrder.getFinishing());
            type.setText(DocumentFormat.myOrder.getPaperType());
            side.setText(DocumentFormat.myOrder.getSide());
            quantity.setText(DocumentFormat.myOrder.getNumberOfPages());
            url.setText(DocumentFormat.myOrder.getUrl());
        } else if (UserHomeActivity.flag == 2) {

            printingFee.setText(String.valueOf(PresentationFormat.myOrder.getPrice()));
            quantity.setText(PresentationFormat.myOrder.getNumberOfPages());
            note.setText(PresentationFormat.myOrder.getNote());

            url.setText(PresentationFormat.myOrder.getUrl());


        } else if (UserHomeActivity.flag == 3) {

            printingFee.setText(String.valueOf(TranslationFormat.myOrder.getPrice()));
            color.setText(TranslationFormat.myOrder.getColor());
            finish.setText(TranslationFormat.myOrder.getFinishing());
            type.setText(TranslationFormat.myOrder.getPaperType());
            side.setText(TranslationFormat.myOrder.getSide());
            quantity.setText(TranslationFormat.myOrder.getNumberOfPages());
            url.setText(TranslationFormat.myOrder.getUrl());

        }


    }

}
