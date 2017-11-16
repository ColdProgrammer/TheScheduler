package com.cs442.srajan.thescheduler;

import android.app.ActionBar;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
