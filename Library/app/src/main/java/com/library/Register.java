package com.library;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.app.ProgressDialog;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.library.R;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {

    private  EditText userName , password , resetPassword , email , phoneNumber ;
    private FirebaseAuth auth;
    private Button signUp ;
    private ProgressDialog PD;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference students = database.getReference("students");
    DatabaseReference admin= database.getReference("admin");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);

        auth = FirebaseAuth.getInstance();
//
//        if (auth.getCurrentUser() != null) {
//            startActivity(new Intent(Register.this, MainActivity.class));
//            finish();
//        }

        userName = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        resetPassword = (EditText) findViewById(R.id.resetpassword);
        phoneNumber = (EditText) findViewById(R.id.phonenumber);
        signUp = (Button) findViewById(R.id.signup);



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View view) {
                final String emailText = email.getText().toString();
                final String passwordText = password.getText().toString();
                final String resetPasswordText = resetPassword.getText().toString();
                final String userNameText = userName.getText().toString();
                final String phoneNumberText = phoneNumber.getText().toString();
                final int key ;


                try {
                    if (password.length() > 0 && email.length() > 0 && userName.length() > 0 && resetPassword.length()>0 && phoneNumber.length()>0 )
                    {
                    if(passwordText.equals(resetPasswordText))


                        {
                            PD.show();
                            auth.createUserWithEmailAndPassword(emailText, passwordText)
                                    .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (!task.isSuccessful()) {
                                                Toast.makeText(
                                                        Register.this,
                                                        "Authentication Failed",
                                                        Toast.LENGTH_LONG).show();
                                                Log.v("error", task.getResult().toString());
                                            } else {

                                                if (MainActivity.flag == 2) {
                                                    Student stu = new Student();
                                                    stu.setUserName(userNameText);
                                                    stu.setEmail(emailText);
                                                    stu.setPassword(passwordText);
                                                    stu.setPhoneNumber(phoneNumberText);

                                                    FirebaseUser curruser = auth.getCurrentUser();

                                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                            .setDisplayName(userNameText).build();

                                                    curruser.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                Log.i("uouoppop", "User profile updated.");
                                                            }
                                                        }
                                                    } );


                                                    Toast.makeText(
                                                            Register.this,
                                                            "Authentication success",
                                                            Toast.LENGTH_LONG).show();
                                                    students.child(userNameText).setValue(stu);

                                                    Intent intent = new Intent(Register.this, Login.class);
                                                    startActivity(intent);
                                                    finish();
                                                } else if (MainActivity.flag == 1) {
                                                    Student stu = new Student();

                                                    stu.setUserName(userNameText);
                                                    stu.setEmail(emailText);
                                                    stu.setPassword(passwordText);
                                                    stu.setPhoneNumber(phoneNumberText);
                                                    FirebaseUser curruser = auth.getCurrentUser();

                                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                            .setDisplayName(userNameText).build();

                                                    curruser.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                Log.i("uouoppop", "User profile updated.");
                                                            }
                                                        }
                                                    } );
                                                    Toast.makeText(
                                                            Register.this,
                                                            "Authentication success",
                                                            Toast.LENGTH_LONG).show();
                                                    admin.child(userNameText).setValue(stu);
                                                    Intent intent = new Intent(Register.this, Login.class);
                                                    startActivity(intent);
                                                    finish();
                                                }


                                            }
                                            PD.dismiss();
                                        }
                                    });
                        }
                        else{

                        Toast.makeText(
                                Register.this,
                                " Password not match",
                                Toast.LENGTH_LONG).show();
                    }
                    } else {
                        Toast.makeText(
                                Register.this,
                                " Please Fill All Fields",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


    public void verify(View view)
    {

        Intent i= new Intent(getApplicationContext(),Verify.class);
        startActivity(i);

    }


}
