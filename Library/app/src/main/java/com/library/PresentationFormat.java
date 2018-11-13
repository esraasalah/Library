package com.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PresentationFormat extends AppCompatActivity {

    static Orders myOrder = new Orders();
    FirebaseUser user;
    FirebaseAuth auth;
    int counter = 1 , totalPrice;
    TextView numberOfSlides , price ;
    EditText email, note;
    Button plus , mins ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_format);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        numberOfSlides=findViewById(R.id.numberofslides);
        price = findViewById(R.id.price);
        email=findViewById(R.id.email);
        plus= findViewById(R.id.plus);
        mins=findViewById(R.id.mins);
        note = findViewById(R.id.note);


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


    public void addToCart(View view) {


        //  finish();


        if (counter >= 0) {
            myOrder.setNumberOfPages(String.valueOf(counter));
            myOrder.setPrice(String.valueOf(totalPrice));
            myOrder.setNote(note.getText().toString());
            myOrder.setUrl(Presentation.url);
            myOrder.setType("designpresentation");
            myOrder.setEmail(user.getEmail());

            Intent i = new Intent(getApplicationContext(), OrderInformation.class);
            startActivity(i);
        } else {

            Toast.makeText(this, "paper quantitiy cann't be less than 1", Toast.LENGTH_LONG).show();
        }

    }






}
