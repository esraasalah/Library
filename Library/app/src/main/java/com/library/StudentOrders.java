package com.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentOrders extends AppCompatActivity {

    private FirebaseAuth auth;
    FirebaseUser user ;
    DatabaseReference ref;
 //   FirebaseDatabase mFirebaseDatabase ;
    String userId ;
    String name;
    Orders objOrder;
    List<Orders>  ordersList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_orders);

        auth = FirebaseAuth.getInstance();
     //   mFirebaseDatabase = FirebaseDatabase.getInstance();
        user = auth.getCurrentUser();
        Log.i("userrrrrrrrrr", user.getDisplayName());

        String currUser = user.getDisplayName();
        userId = user.getUid() ;

        ordersList = new ArrayList<Orders>();


       ref = FirebaseDatabase.getInstance().getReference();


            ref.child("students").child(user.getDisplayName()).child("orders").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                             objOrder = new Orders();

                             objOrder.setColor(ds.child("color").getValue(String.class));
                             objOrder.setUrl(ds.child("url").getValue(String.class));

                             ordersList.add(objOrder);







                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {




                    }


            });





    }



    public  void getOrders (View view)
    {

//        Log.i("dataaaaaaaaaaaaa",ordersList.get(0).getColor());
    }


}
