package com.cs442.srajan.thescheduler;

import android.os.AsyncTask;

/**
 * Created by project on 27/11/17.
 *
 * To add courses into the database
 *
 */

public class SavingCoursesAsyncTask extends AsyncTask {
    public SavingCoursesAsyncTask() {
        super();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String[][] coursesString = StaticVariables.ALL_COURSES;
        for(int i=0;i<coursesString.length; i++){
            for (int j=0;j<coursesString[j].length;j++){
                //Adding courses to the database
            }
        }
        return null;
    }
}
