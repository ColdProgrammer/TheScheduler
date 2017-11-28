package com.cs442.srajan.thescheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //To get the back button on Title Bar
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void startClassListActivity(View view){
        Intent intent = new Intent(this,ClassListActivity.class);
        startActivity(intent);
    }
    public void startInputClassActivity(View view) {
        //On click of the button open Input Classes activity
        startActivity(new Intent(view.getContext(), InputClassActivity.class));
    }
}
