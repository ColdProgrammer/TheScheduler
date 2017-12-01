package com.cs442.srajan.thescheduler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);
        SharedPreferences sharedPreferences = this.getSharedPreferences(StaticVariables.SHAREDPREFERENCE_USER_NAME, Context.MODE_PRIVATE);

        Log.d("sharedPref","value is " + sharedPreferences.getString(StaticVariables.USER_ID_USER_ID,""));
    }

    public void startClassListActivity(View view) {
        startActivity(new Intent(this, ClassListActivity.class));
    }

    public void addEventToCalendar(){
        //TODO
    }

    public void viewSelectedCourses(View view) {
        //Opens the current courses selected
        startActivity(new Intent(this, ViewAllClasses.class));
    }

    public void goToMaps(View view) {
        startActivity(new Intent(this, LocationActivity.class));
    }
}
