package com.cs442.srajan.thescheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalenderViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_view);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
