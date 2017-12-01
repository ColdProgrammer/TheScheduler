package com.cs442.srajan.thescheduler;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.cs442.srajan.thescheduler.database.DAO;

public class LocationChooserActivity extends AppCompatActivity {

    protected static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_chooser);
    }


    public void save(Context context, String courseNum, String location, String semester) {
        SharedPreferences sp;
        SharedPreferences.Editor editor;
        String locations;
        String courses;
        String semesters;
        String userId;
        String userName;

        //The preference file name is stored in strings.xml
        String prefFile = getString(R.string.preference_file);
        sp = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE); //1

        //Read current preference file to check for any existing locations or courses
        locations = sp.getString("COURSE_LOCATIONS","");
        courses = sp.getString("STUDENT_COURSES","");
        semesters = sp.getString("COURSE_SEMESTERS","");

        editor = sp.edit(); //2

        //Append to preference file
        editor.putString("STUDENT_COURSES", courses+courseNum+","); //3
        editor.putString("COURSE_LOCATIONS", locations+location+",");
        editor.putString("COURSE_SEMESTERS", semesters+semester+",");



        SharedPreferences sharedPreferences = this.getSharedPreferences(StaticVariables.SHAREDPREFERENCE_USER_NAME, Context.MODE_PRIVATE);

        userId = sharedPreferences.getString(StaticVariables.USER_ID_USER_ID,"");
        userName = sharedPreferences.getString(StaticVariables.USER_ID_USER_NAME,"");

        new DAO(this).addUserCourses(userId, userName, semester, courseNum, location);

        editor.commit(); //4
    }

    //When the input class button is clicked, add class to database
    public void addCourseToStudent(View view) {
        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerLocation);
        Spinner semesterSpinner = (Spinner) findViewById(R.id.spinnerSemester);

        String location = mySpinner.getSelectedItem().toString();
        String semester = semesterSpinner.getSelectedItem().toString();

        Toast.makeText(this, name + " " + location, Toast.LENGTH_SHORT).show();

        //Save to SharedPreferences
        save(this, name, location, semester);
    }
}
