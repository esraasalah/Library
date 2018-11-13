package com.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Payment extends AppCompatActivity {


    FirebaseUser user ;
    DatabaseReference ref;
    String userNameT="";
    private FirebaseAuth auth;

    //    Map map = new HashMap();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        auth = FirebaseAuth.getInstance();
        user =auth.getCurrentUser();


//        map.put("timestamp", ServerValue.TIMESTAMP);

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

        if (UserHomeActivity.flag == 1) {
            ref.child("students").child("printingOrders").push().setValue(DocumentFormat.myOrder);
            ref.child("students").child(user.getDisplayName()).child("orders").push().setValue(DocumentFormat.myOrder);
            // ref.child("students").child(user.getDisplayName()).child("orders").updateChildren(map);
            Log.i("flagggggg", String.valueOf(UserHomeActivity.flag));
        } else if (UserHomeActivity.flag == 2) {
            ref.child("students").child("presentationOrders").push().setValue(PresentationFormat.myOrder);
            ref.child("students").child(user.getDisplayName()).child("orders").push().setValue(PresentationFormat.myOrder);
            Log.i("flagggggg", String.valueOf(UserHomeActivity.flag));

        } else if (UserHomeActivity.flag == 3) {
            ref.child("students").child("translationOrders").push().setValue(TranslationFormat.myOrder);
            ref.child("students").child(user.getDisplayName()).child("orders").push().setValue(TranslationFormat.myOrder);
            Log.i("flagggggg", String.valueOf(UserHomeActivity.flag));

        }

        Intent i = new Intent(getApplicationContext() , OrderStatus.class);
        startActivity(i);

    }
}
