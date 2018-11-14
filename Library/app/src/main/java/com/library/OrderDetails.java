package com.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class OrderDetails extends AppCompatActivity {
    TextView color, type, quantity, side, finish, url, note, price, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);


        price = findViewById(R.id.price);
        color = findViewById(R.id.color);
        type = findViewById(R.id.type);
        quantity = findViewById(R.id.quantity);
        side = findViewById(R.id.side);
        finish = findViewById(R.id.finish);
        note = findViewById(R.id.notes);
        url = findViewById(R.id.url);
        email = findViewById(R.id.studentmail);


        showDetails();

    }


    public void back(View view) {

        startActivity(new Intent(getApplicationContext(), AdminOrders.class));


    }


    public void showDetails() {

        if (AdminOrders.flag == 1) {

            email.setText(String.valueOf(AdminOrders.orderArrayList.get(AdminOrders.pos).getEmail()));
            price.setText(String.valueOf(AdminOrders.orderArrayList.get(AdminOrders.pos).getPrice()));
            color.setText(AdminOrders.orderArrayList.get(AdminOrders.pos).getColor());
            finish.setText(AdminOrders.orderArrayList.get(AdminOrders.pos).getFinishing());
            type.setText(AdminOrders.orderArrayList.get(AdminOrders.pos).getPaperType());
//            side.setText(AdminOrders.orderArrayList.get(AdminOrders.pos).getSide());
            quantity.setText(AdminOrders.orderArrayList.get(AdminOrders.pos).getNumberOfPages());
            url.setText(AdminOrders.orderArrayList.get(AdminOrders.pos).getUrl());

        } else if (AdminOrders.flag == 2) {

            price.setText(String.valueOf(PresentationFormat.myOrder.getPrice()));
            quantity.setText(PresentationFormat.myOrder.getNumberOfPages());
            note.setText(PresentationFormat.myOrder.getNote());

            url.setText(PresentationFormat.myOrder.getUrl());


        } else if (AdminOrders.flag == 3) {

            price.setText(String.valueOf(TranslationFormat.myOrder.getPrice()));
            color.setText(TranslationFormat.myOrder.getColor());
            finish.setText(TranslationFormat.myOrder.getFinishing());
            type.setText(TranslationFormat.myOrder.getPaperType());
            side.setText(TranslationFormat.myOrder.getSide());
            quantity.setText(TranslationFormat.myOrder.getNumberOfPages());
            url.setText(TranslationFormat.myOrder.getUrl());

        }


    }



}
