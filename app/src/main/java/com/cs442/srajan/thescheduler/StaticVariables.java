package com.cs442.srajan.thescheduler;

import android.support.design.widget.TextInputEditText;
import android.widget.EditText;

/**
 * Created by project on 24/11/17.
 *
 * For all the static Variables in the project
 */

public class StaticVariables {
    // Database Version
    public static final int DATABASE_VERSION = 1;
    // Database Name
    public static final String DATABASE_NAME = "TheScheduler.db";
    // User table name
    public static final String TABLE_USER = "user";
    // User Table Columns names
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_FORGOT_QUESTION = "user_frgt_quest";
    public static final String COLUMN_USER_FORGOT_ANS = "user_frgt_ans";
    public static final String COLUMN_USER_PASSWORD = "user_password";

    /**
     * Function to check if the edit text is empty
     *
     * @param editText
     * @return false if edit text has a value
     * @return true if edit text is null
     *
     **/
    public static boolean checkEditTextIsEmpty(EditText editText){
        return editText.getText().toString() == null;

    }
}
