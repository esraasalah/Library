package com.library;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    EditText email ;
    Button send ;
    String userEmail ;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email = findViewById(R.id.email);
        send = findViewById(R.id.send);


    }


    public void sendMail(View view) {
        String emailText = email.getText().toString();

        if (email.length() <= 0) {
            Toast.makeText(ForgetPassword.this, "enter your university email", Toast.LENGTH_LONG).show();
        } else {


            auth.sendPasswordResetEmail(emailText)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.i("success", "Email sent.");
                                Toast.makeText(ForgetPassword.this, "Email Sent", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }


    }

}
