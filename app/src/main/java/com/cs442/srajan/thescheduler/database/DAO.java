package com.cs442.srajan.thescheduler.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cs442.srajan.thescheduler.StaticVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by project on 24/11/17.
 *
 * This class is for updating the database, tables and such
 */

public class DAO extends SQLiteOpenHelper {

    // Database Version
    private static final String TAG = "DAO";
    private static final int DATABASE_VERSION = StaticVariables.DATABASE_VERSION;
    // Database Name
    private static final String DATABASE_NAME = StaticVariables.DATABASE_NAME;
    // User table name
    private static final String TABLE_USER = StaticVariables.TABLE_USER;
    // User Table Columns names
    private static final String COLUMN_USER_ID = StaticVariables.COLUMN_USER_ID;
    private static final String COLUMN_USER_NAME = StaticVariables.COLUMN_USER_NAME;
    private static final String COLUMN_USER_FORGOT_QUESTION = StaticVariables.COLUMN_USER_FORGOT_QUESTION;
    private static final String COLUMN_USER_FORGOT_ANS = StaticVariables.COLUMN_USER_FORGOT_ANS;
    private static final String COLUMN_USER_PASSWORD = StaticVariables.COLUMN_USER_PASSWORD;
    //Course table name
    public static final String TABLE_COURSE = StaticVariables.TABLE_COURSE;
    //Course Table Column names
    public static final String COLUMN_COURSE_ID = StaticVariables.COLUMN_COURSE_ID;
    public static final String COLUMN_COURSE_NUMBER = StaticVariables.COLUMN_COURSE_NUMBER;
    public static final String COLUMN_COURSE_NAME = StaticVariables.COLUMN_COURSE_NAME;
    public static final String COLUMN_COURSE_SPRING_YN = StaticVariables.COLUMN_COURSE_SPRING_YN;
    public static final String COLUMN_COURSE_DESCRIPTION = StaticVariables.COLUMN_COURSE_DESCRIPTION;
    public static final String COLUMN_COURSE_PREREQUISITES = StaticVariables.COLUMN_COURSE_PREREQUISITES;
    public static final String COLUMN_COURSE_CREDITS = StaticVariables.COLUMN_COURSE_CREDITS;

    // create table sql query - user
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_FORGOT_QUESTION + " TEXT," + COLUMN_USER_FORGOT_ANS + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    // create table sql query - course
    private String CREATE_COURSE_TABLE = "CREATE TABLE " + TABLE_COURSE + "("
            + COLUMN_COURSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_COURSE_NUMBER + " TEXT,"
            + COLUMN_COURSE_NAME + " TEXT," + COLUMN_COURSE_SPRING_YN + " TEXT," +
            COLUMN_COURSE_DESCRIPTION + " TEXT," + COLUMN_COURSE_PREREQUISITES + " TEXT," +
            COLUMN_COURSE_CREDITS + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    public DAO(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //Drop User Table if exist
        sqLiteDatabase.execSQL(DROP_USER_TABLE);
        // Create tables again
        onCreate(sqLiteDatabase);
    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_FORGOT_QUESTION, user.getFrgtquestion());
        values.put(COLUMN_USER_FORGOT_ANS, user.getFrgtanswer());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_FORGOT_QUESTION,
                COLUMN_USER_FORGOT_ANS,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setFrgtquestion(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FORGOT_QUESTION)));
                user.setFrgtanswer(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FORGOT_ANS)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_FORGOT_QUESTION, user.getFrgtquestion());
        values.put(COLUMN_USER_FORGOT_ANS, user.getFrgtanswer());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }



    /**
     * This method to check user exist or not
     *
     * @param userId
     * @param password
     * @return true/false
     */
    public boolean checkUser(String userId, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_NAME + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {userId, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         *
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        return cursorCount > 0;
    }

    /**
     * This method to add courses into the courses table
     *
     * @param course
     * @return true/false
     */
    public void addCourses(Course course) {
        Log.d(TAG +" value of the course", course.getCourseNumber().toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COURSE_NUMBER, course.getCourseNumber());
        values.put(COLUMN_COURSE_NAME, course.getCourseName());
        values.put(COLUMN_COURSE_SPRING_YN, course.getSpringClass());
        values.put(COLUMN_COURSE_DESCRIPTION, course.getCourseDescription());
        values.put(COLUMN_COURSE_PREREQUISITES, course.getPrereq());
        values.put(COLUMN_COURSE_CREDITS, course.getCreditValue());
        // Inserting Row
        db.insert(TABLE_COURSE, null, values);
        db.close();
    }
}
