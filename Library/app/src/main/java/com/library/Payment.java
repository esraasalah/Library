package com.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.library.R;

public class Payment extends AppCompatActivity {


    private FirebaseAuth auth;
    FirebaseUser user ;
    DatabaseReference ref;
    String userNameT="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        auth = FirebaseAuth.getInstance();
        user =auth.getCurrentUser();

        ref= FirebaseDatabase.getInstance().getReference();
        ref.addValueEventListener(new ValueEventListener() {
                                      @Override
                                      public void onDataChange(DataSnapshot dataSnapshot) {

                                          userNameT = dataSnapshot.child("students").child(user.getDisplayName()).child("userName").getValue(String.class);
                                          DocumentFormat.myOrder.setStudentName(userNameT);



                                      }

                                      @Override
                                      public void onCancelled(DatabaseError databaseError) {

                                      }
                                  }

        );
    }


    public void getOrderStatus (View view)
    {


        ref.child("students").child(user.getDisplayName()).child("orders").push().setValue(DocumentFormat.myOrder);

        Intent i = new Intent(getApplicationContext() , OrderStatus.class);
        startActivity(i);

    }
}
