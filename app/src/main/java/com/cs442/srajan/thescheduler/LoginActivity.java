package com.cs442.srajan.thescheduler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

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
        layoutLogin = findViewById(R.id.loginLinearLayout);
        editTextUserName = findViewById(R.id.tietLoginSignInUserName);
        editTextPassword = findViewById(R.id.tietSignInPassword);
        databaseHelper = new DAO(LoginActivity.this);

        //commenting this out, broken rn :(
        //        new SavingCoursesAsyncTask(LoginActivity.this).execute();

        //populate the student course sharedPreferences with blank values
        loadInitialValues();

    }

    public void signUpFunct(View view) {
        //On click of the button open sign-up page
        resetVal();
        startActivity(new Intent(view.getContext(), SignUpActivity.class));
    }

    public void signInFunct(View view) {
        //On click of the sign-in page

        startActivity(new Intent(view.getContext(), MainActivity.class));


//        if(!(StaticVariables.checkEditTextIsEmpty(editTextPassword) && StaticVariables.checkEditTextIsEmpty(editTextPassword))) {
//            if (databaseHelper.checkUser(this,editTextUserName.getText().toString(), editTextPassword.getText().toString())) {
//                //Correct Password
//                startActivity(new Intent(view.getContext(), MainActivity.class));
//            } else {
//                resetVal();
//                //Snackbar.make(layoutLogin, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
//                StaticVariables.themedSnackBar(layoutLogin, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG, Color.parseColor("#FFFFFF")).show();
//            }
//        } else {
//            //Snackbar.make(layoutLogin, getString(R.string.error_no_username_password), Snackbar.LENGTH_LONG).show();
//            StaticVariables.themedSnackBar(layoutLogin, getString(R.string.error_no_username_password), Snackbar.LENGTH_LONG, Color.parseColor("#FFFFFF")).show();
//        }
    }

    /**
     * Function to reset all the values in the activity
     *
     * */
    private void resetVal() {
        editTextUserName.setText("");
        editTextPassword.setText("");
    }

    //populate the student course sharedPreferences with blank values (at login)
    private void loadInitialValues(){
        SharedPreferences sp;
        SharedPreferences.Editor editor;

        String prefFile = getString(R.string.preference_file);
        sp = getSharedPreferences(prefFile, Context.MODE_PRIVATE); //1

        editor = sp.edit(); //2

        editor.putString("STUDENT_COURSES", ""); //3
        editor.putString("COURSE_LOCATIONS", "");
        editor.commit(); //4
    }
}
