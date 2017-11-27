package com.cs442.srajan.thescheduler;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cs442.srajan.thescheduler.database.DAO;
import com.cs442.srajan.thescheduler.database.User;

public class SignUpActivity extends AppCompatActivity {

    DAO dao;
    TextInputEditText inputEditTextSignUpName, inputEditTextSignUpPassword, inputEditTextSignUpFrgtQuest, inputEditTextSignUpFrgtAns;
    Context context = SignUpActivity.this;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);

        layout = (LinearLayout) findViewById(R.id.signUpLinearLayout);
        inputEditTextSignUpName = (TextInputEditText) findViewById(R.id.tietSignUpUserName);
        inputEditTextSignUpPassword = (TextInputEditText) findViewById(R.id.tietSignUpPassword);
        inputEditTextSignUpFrgtQuest = (TextInputEditText) findViewById(R.id.tietSignUpQuestion);
        inputEditTextSignUpFrgtAns = (TextInputEditText) findViewById(R.id.tietSignUpAns);
        dao = new DAO(context);
    }

    public void signingUpNewUser(View view) {
        //To sign up new users
        if(StaticVariables.checkEditTextIsEmpty(inputEditTextSignUpName) &&
                StaticVariables.checkEditTextIsEmpty(inputEditTextSignUpPassword) &&
                StaticVariables.checkEditTextIsEmpty(inputEditTextSignUpFrgtQuest) &&
                StaticVariables.checkEditTextIsEmpty(inputEditTextSignUpFrgtAns)) {
            User user = new User();
            user.setName(inputEditTextSignUpName.getText().toString());
            user.setPassword(inputEditTextSignUpPassword.getText().toString());
            user.setFrgtanswer(inputEditTextSignUpFrgtAns.getText().toString());
            user.setFrgtquestion(inputEditTextSignUpFrgtQuest.getText().toString());
            dao.addUser(user);
            Toast.makeText(context, "Entered Details", Toast.LENGTH_LONG).show();
            startActivity(new Intent(context, LoginActivity.class));
        } else {
            StaticVariables.themedSnackBar(layout, getString(R.string.error_no_details), Snackbar.LENGTH_LONG, Color.parseColor("#FFFFFF")).show();
        }
    }
}
