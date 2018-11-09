package com.library;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.library.R;

public class Verify extends AppCompatActivity  {


    private FirebaseAuth auth;
    private Button verify ;
    private ProgressDialog PD;
    EditText code ;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference students = database.getReference("students");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);


        verify = findViewById(R.id.verifyBtn);
        code = findViewById(R.id.editTextCode);

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);

        auth = FirebaseAuth.getInstance();


        verify.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View view) {


                try {

                    final String codeText = code.getText().toString();

                    if (codeText.equals(Register.code) )

                    {

                        Log.i("code" , Register.code);

                        PD.show();
                        auth.createUserWithEmailAndPassword(Register.stu.getEmail(), Register.stu.getPassword())
                                .addOnCompleteListener(Verify.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(
                                                    Verify.this,
                                                    "Authentication Failed",
                                                    Toast.LENGTH_LONG).show();
                                            Log.v("error", task.getResult().toString());
                                        } else {

                                            if (MainActivity.flag == 2) {


                                                FirebaseUser curruser = auth.getCurrentUser();

                                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                        .setDisplayName(Register.stu.getUserName()).build();

                                                curruser.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Log.i("uouoppop", "User profile updated.");
                                                        }
                                                    }
                                                } );


                                                Toast.makeText(
                                                         Verify.this,
                                                        "Authentication success",
                                                        Toast.LENGTH_LONG).show();
                                                students.child(Register.stu.getUserName()).setValue(Register.stu);

                                                Intent intent = new Intent(Verify.this, Login.class);
                                                startActivity(intent);
                                                finish();
                                           }// else if (MainActivity.flag == 1) {
//                                                Student stu = new Student();
//
//
//                                                FirebaseUser curruser = auth.getCurrentUser();
//
//                                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                                                        .setDisplayName(userNameText).build();
//
//                                                curruser.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                    @Override
//                                                    public void onComplete(@NonNull Task<Void> task) {
//                                                        if (task.isSuccessful()) {
//                                                            Log.i("uouoppop", "User profile updated.");
//                                                        }
//                                                    }
//                                                } );
//                                                Toast.makeText(
//                                                        Verify.this,
//                                                        "Authentication success",
//                                                        Toast.LENGTH_LONG).show();
//                                                admin.child(userNameText).setValue(stu);
//                                                Intent intent = new Intent(Verify.this, Login.class);
//                                                startActivity(intent);
//                                                finish();
//                                            }


                                        }
                                        PD.dismiss();
                                    }
                                });

                    }
                    else
                    {

                        Log.i("code" , "not match");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


                }


            }




