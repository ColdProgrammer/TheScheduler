package com.cs442.srajan.thescheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LocationChooserActivity extends AppCompatActivity {

    protected static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_chooser);
    }


    //When the input class button is clicked, add class to database
    public void addCourseToStudent(View view){
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();

    }
}
