package com.library;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.library.R;

public class ForgetPassword extends AppCompatActivity {

    EditText email ;
    String userEmail ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email = findViewById(R.id.email);

        email.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {

                // TODO Auto-generated method stub

                new Thread(new Runnable() {

                    public void run() {

                        try {

                            GMailSender sender = new GMailSender(

                                    "libraryesy544@gmail.com",

                                    "library&123");



                          //  sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                            sender.sendMail("Test mail", "This mail has been sent from android app along with attachment",

                                    "libraryesy544@gmail.com",

                                    "esraasalah937@gmail.com");









                        } catch (Exception e) {

                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();



                        }


                        Log.i ("senddddddddddd","maillll");

                    }

                }).start();

            }

        });




    }




//    public void sendMail(View view)
//    {
//
//        userEmail  = email.getText().toString();
//
//        if (userEmail != null) {
//            try {
//
//                Intent sendEmail = new Intent(Intent.ACTION_SEND);
//
//                sendEmail.setData(Uri.parse("mailto:"));
//                sendEmail.setType("message/rfc822");
//                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{userEmail});
//                sendEmail.putExtra(Intent.EXTRA_TEXT, "123456");
//
//                startActivity(sendEmail);
//            } catch (Exception e) {
//
//                Toast.makeText(this, "please try again", Toast.LENGTH_LONG);
//
//            }
//
//        }
//        else
//        {
//
//            Toast.makeText(this, "please Enter your mail", Toast.LENGTH_LONG);
//
//        }
//
//    }

}
