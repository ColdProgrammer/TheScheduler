package com.cs442.srajan.thescheduler;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void startClassListActivity(View view) {
        Intent intent = new Intent(this, ClassListActivity.class);
        startActivity(intent);
    }

    public void addEventToCalendar(){
        //TODO
    }
}
