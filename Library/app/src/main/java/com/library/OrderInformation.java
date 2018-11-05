package com.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.library.R;

public class OrderInformation extends AppCompatActivity {

    TextView color , type , quantity , side , finish , url;

    TextView printingFee ;
//    private FirebaseAuth auth;
//    FirebaseUser user ;
//    DatabaseReference ref;
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
        url = findViewById(R.id.url);

        printingFee.setText(String.valueOf(DocumentFormat.totalPrice));
//
//        auth = FirebaseAuth.getInstance();
//        user =auth.getCurrentUser();
//
//        ref= FirebaseDatabase.getInstance().getReference();
//        ref.addValueEventListener(new ValueEventListener() {
//                                      @Override
//                                      public void onDataChange(DataSnapshot dataSnapshot) {
//
//                                           userNameT = dataSnapshot.child("students").child(user.getDisplayName()).child("userName").getValue(String.class);
//                                           DocumentFormat.myOrder.setStudentName(userNameT);
//
//
//
//                                      }
//
//                                      @Override
//                                      public void onCancelled(DatabaseError databaseError) {
//
//                                      }
//                                  }
//
//        );


        color.setText(DocumentFormat.myOrder.getColor());
        finish.setText(DocumentFormat.myOrder.getFinishing());
        type.setText(DocumentFormat.myOrder.getPaperType());
        side.setText(DocumentFormat.myOrder.getSide());
        quantity.setText(DocumentFormat.myOrder.getNumberOfPages());
        url.setText(DocumentFormat.myOrder.getUrl());


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



}
