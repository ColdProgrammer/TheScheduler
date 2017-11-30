package com.cs442.srajan.thescheduler.Adapter;

import com.cs442.srajan.thescheduler.database.Course;

import java.util.ArrayList;

/**
 * Created by project on 29/11/17.
 *
 * This is for class used in adapter
 */

public class User_sem_details {
    public String sem;
    public Course course_name;
    private ArrayList user_sem_details_list;

    User_sem_details(String sem, Course course_name){
        this.sem = sem;
        this.course_name = course_name;
    }

    private void initializeData(){
        user_sem_details_list = new ArrayList();
        user_sem_details_list.add(new User_sem_details("1",new Course(12,"23","2333","Sample1","This is a sample course","professor","Deptartment","SB" )));
        user_sem_details_list.add(new User_sem_details("1",new Course(13,"24","2444","Sample2","This is a sample course","professor","Deptartment","SB" )));
        user_sem_details_list.add(new User_sem_details("2",new Course(14,"25","2555","Sample3","This is a sample course","professor","Deptartment","SB" )));
    }
}
