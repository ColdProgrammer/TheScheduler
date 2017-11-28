package com.cs442.srajan.thescheduler;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.cs442.srajan.thescheduler.database.Course;
import com.cs442.srajan.thescheduler.database.DAO;

/**
 * Created by project on 27/11/17.
 *
 * To add courses into the database
 *
 */

public class SavingCoursesAsyncTask extends AsyncTask {
    private Context context;
    public SavingCoursesAsyncTask(Context context) {
        super();
        this.context = context;
    }

    protected Object doInBackground(Object[] objects) {
        String[][] coursesString = StaticVariables.ALL_COURSES;
        for(int i=0;i<coursesString.length; i++){
            for (int j=0;j<coursesString[i].length;j++){
                //Adding courses to the database
                String[] courseArray = coursesString[i];//All the course details in an array
                Log.d("The course info" , courseArray[0]);
                Course course  =  new Course();
                course.setCourseNumber(courseArray[0].trim().toString());
                course.setCourseName(courseArray[1].trim().toString());
                course.setSpringClass(courseArray[2].trim().toString());
                course.setCourseDescription(courseArray[3].trim().toString());
                course.setPrereq(courseArray[4].trim().toString());
                course.setCreditValue(courseArray[5].trim().toString());

                //Now that we have all the courses we have to enter them into the database
                new DAO(context).addCourses(course);
            }
        }
        return null;
    }
}
