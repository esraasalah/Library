package com.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.library.R;

public class LoginOrRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);

    }

    public void signIn(View view){


        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);


    }
    public void signUp(View view){


        Intent i = new Intent(getApplicationContext(),Register.class);
        startActivity(i);


    }

}
