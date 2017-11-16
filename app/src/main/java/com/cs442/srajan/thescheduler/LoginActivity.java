package com.cs442.srajan.thescheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void signUpFunct(View view){
        //On click of the button open sign-up page
        startActivity(new Intent(view.getContext(), SignUpActivity.class));
    }
}
