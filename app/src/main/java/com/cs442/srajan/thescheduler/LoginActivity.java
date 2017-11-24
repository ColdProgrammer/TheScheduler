package com.cs442.srajan.thescheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);

        editTextUserName = (EditText) findViewById(R.id.tietLoginSignInUserName);
        editTextPassword = (EditText) findViewById(R.id.tietSignInPassword);
    }

    public void signUpFunct(View view){
        //On click of the button open sign-up page
        startActivity(new Intent(view.getContext(), SignUpActivity.class));
    }

    public void signInFunct(View view){
        //On click of the sign-in page
        if(editTextUserName.getText().toString() == "admin" && editTextPassword.getText().toString() == "admin"){
            //Correct Password

        }else{
            Toast.makeText(LoginActivity.this, "The password entered is wrong", Toast.LENGTH_LONG).show();
            editTextPassword.setText("");
            editTextUserName.setText("");
        }
    }
}
