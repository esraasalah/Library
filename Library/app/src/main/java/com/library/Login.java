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

import com.library.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText userNameInputText , passwordInputText ;

    private Button loginBtn ;

    private ProgressDialog pD ;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);


        pD = new ProgressDialog(this);
        pD.setMessage("LogIn ....");
        pD.setCancelable(true);
        pD.setCanceledOnTouchOutside(true);

        auth = FirebaseAuth.getInstance();


        userNameInputText = findViewById(R.id.usernameinputtext);
        passwordInputText = findViewById(R.id.passwordinputtext);
        loginBtn = findViewById(R.id.loginbutton);

        loginBtn.setOnClickListener(new View.OnClickListener(){

          @Override  public void  onClick ( View view) {

              final String name = userNameInputText.getText().toString();
              final String password = passwordInputText.getText().toString();




                  if (name.length() > 0 && password.length() > 0) {
                      pD.show();

                      if (name.equals("admin@admin.com")&& password.equals("123456") && MainActivity.flag==1)
                      {

                          Toast.makeText(Login.this, "successful", Toast.LENGTH_LONG).show();
                                              Intent intent = new Intent(Login.this, AdminHomeActivity.class);
                                              startActivity(intent);
                                              finish();

                      }
                      else {
                          auth.signInWithEmailAndPassword(name, password)
                                  .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                      @Override
                                      public void onComplete(@NonNull Task<AuthResult> task) {
                                          if (task.isSuccessful() && MainActivity.flag == 2) {

                                              Toast.makeText(Login.this, "successful", Toast.LENGTH_LONG).show();

                                              Intent intent = new Intent(Login.this, UserHomeActivity.class);
                                              startActivity(intent);
                                              finish();
                                          }
//                                          else if ( task.isSuccessful() && MainActivity.flag ==1)
//
//                                          {
//
//                                              Toast.makeText(Login.this, "successful", Toast.LENGTH_LONG).show();
//                                              Intent intent = new Intent(Login.this, AdminHomeActivity.class);
//                                              startActivity(intent);
//                                              finish();
//
//                                          }
                                          else {

                                              Toast.makeText(Login.this, "failed , email or password not correct    ", Toast.LENGTH_SHORT).show();
                                          }
                                          pD.dismiss();
                                      }
                                  });
                      }
                  } else {

                      Toast.makeText(Login.this, "fill all fields", Toast.LENGTH_LONG).show();


                  }



            }







        });


        findViewById(R.id.forgetpassword).setOnClickListener(new View.OnClickListener()


        {

            @Override
            public void onClick(View view) {


                startActivity(new Intent(getApplicationContext(), ForgetPassword.class));

            }


        });

    }
//        public void login(View view)
//    {
//
//        if (MainActivity.flag==1)
//        {
//            startActivity(new Intent(getApplicationContext(),UserHomeActivity.class));
//
//        }
//        else if (MainActivity.flag==2)
//        {
//
//            startActivity(new Intent(getApplicationContext(),AdminHomeActivity.class));
//        }
//
//
//    }









}
