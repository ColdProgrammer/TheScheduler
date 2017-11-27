package com.cs442.srajan.thescheduler;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cs442.srajan.thescheduler.database.DAO;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword;
    LinearLayout layoutLogin;
    DAO databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);

        layoutLogin = (LinearLayout) findViewById(R.id.loginLinearLayout);
        editTextUserName = (EditText) findViewById(R.id.tietLoginSignInUserName);
        editTextPassword = (EditText) findViewById(R.id.tietSignInPassword);
        databaseHelper = new DAO(LoginActivity.this);
    }

    public void signUpFunct(View view){
        //On click of the button open sign-up page
        startActivity(new Intent(view.getContext(), SignUpActivity.class));
    }

    public void signInFunct(View view){
        //On click of the sign-in page
        if(databaseHelper.checkUser(editTextUserName.getText().toString(), editTextPassword.getText().toString())){
            //Correct Password
            startActivity(new Intent(view.getContext(), MainActivity.class));
        }else{
            Snackbar.make(layoutLogin, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
            editTextPassword.setText("");
            editTextUserName.setText("");
        }
    }
}
