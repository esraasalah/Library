package com.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {



    FirebaseUser user ;
    DatabaseReference ref;
   EditText name , email , phone ;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        name =findViewById(R.id.name);
        email =findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        auth = FirebaseAuth.getInstance();
        user =auth.getCurrentUser();


        ref= FirebaseDatabase.getInstance().getReference();


        if (MainActivity.flag == 1) {
//
//            ref.addValueEventListener(new ValueEventListener() {
//                                          @Override
//                                          public void onDataChange(DataSnapshot dataSnapshot) {
//
//                                              String userNameT = dataSnapshot.child("admin").child(user.getDisplayName()).child("userName").getValue(String.class);
//                                              String emailT = dataSnapshot.child("admin").child(user.getDisplayName()).child("email").getValue(String.class);
//                                              String phoneNumberT = dataSnapshot.child("admin").child(user.getDisplayName()).child("phoneNumber").getValue(String.class);

                                              name.setText("admin");
                                              email.setText("admin@admin.com");
                                              phone.setText("28373992302");

//                                          }
//
//                                          @Override
//                                          public void onCancelled(DatabaseError databaseError) {
//
//                                          }
//                                      }
//
//            );

        }
        else if (MainActivity.flag==2)
        {
            ref.addValueEventListener(new ValueEventListener() {
                                          @Override
                                          public void onDataChange(DataSnapshot dataSnapshot) {

                                              String userNameT = dataSnapshot.child("students").child(user.getDisplayName()).child("userName").getValue(String.class);
                                              String emailT = dataSnapshot.child("students").child(user.getDisplayName()).child("email").getValue(String.class);
                                              String phoneNumberT = dataSnapshot.child("students").child(user.getDisplayName()).child("phoneNumber").getValue(String.class);

                                              name.setText(userNameT);
                                              email.setText(emailT);
                                              phone.setText(phoneNumberT);

                                          }

                                          @Override
                                          public void onCancelled(DatabaseError databaseError) {

                                          }
                                      }

            );

        }


    }


    public void save (View view)
    {

        if (!email.getText().toString().contains("pnu.edu.sa")) {
            Toast.makeText(this, "Enter a valid university email", Toast.LENGTH_LONG).show();
        } else {
            ref.child("students").child(user.getDisplayName()).child("userName").setValue(name.getText().toString());
            // ref.child("students").child(user.getDisplayName()).child("email").setValue(email.getText().toString());
            ref.child("students").child(user.getDisplayName()).child("phoneNumber").setValue(phone.getText().toString());
            user.updateEmail(email.getText().toString());

            Toast.makeText(this, "data updating successfuly", Toast.LENGTH_LONG).show();
        }

    }
}
