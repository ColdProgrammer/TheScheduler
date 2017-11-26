package com.cs442.srajan.thescheduler;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cs442.srajan.thescheduler.database.DAO;
import com.cs442.srajan.thescheduler.database.User;

public class SignUpActivity extends AppCompatActivity {

    DAO dao;
    TextInputEditText inputEditTextSignUpName, inputEditTextSignUpPassword, inputEditTextSignUpFrgtQuest, inputEditTextSignUpFrgtAns;
    Context context = SignUpActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);

        inputEditTextSignUpName = (TextInputEditText) findViewById(R.id.tietSignUpUserName);
        inputEditTextSignUpPassword = (TextInputEditText) findViewById(R.id.tietSignUpPassword);
        inputEditTextSignUpFrgtQuest = (TextInputEditText) findViewById(R.id.tietSignUpQuestion);
        inputEditTextSignUpFrgtAns = (TextInputEditText) findViewById(R.id.tietSignUpAns);
        dao = new DAO(context);
    }

    public void signingUpNewUser(View view) {
        //To sign up new users
        User user = new User();
        user.setName(inputEditTextSignUpName.getText().toString());
        user.setPassword(inputEditTextSignUpPassword.getText().toString());
        user.setFrgtanswer(inputEditTextSignUpFrgtAns.getText().toString());
        user.setFrgtquestion(inputEditTextSignUpFrgtQuest.getText().toString());
        dao.addUser(user);
        Toast.makeText(context,"Entered Details", Toast.LENGTH_LONG).show();
        startActivity(new Intent(context, LoginActivity.class));
    }
}
