package com.cs442.srajan.thescheduler.database;

import java.util.ArrayList;

/**
 * Created by project on 24/11/17.
 *
 * This contains getter and setter methods for User
 */

public class User {

    private int id;
    private String name;
    private String frgtquestion;
    private String frgtanswer;
    private String password;

    //list of class crns already taken
    private ArrayList<Integer> crnList;

    //number of credits currently taking
    private int creditsTaking;

    public User(int id, String name, String frgtquestion, String frgtanswer, String password, int creditsTaking) {
        this.id = id;
        this.name = name;
        this.frgtquestion = frgtquestion;
        this.frgtanswer = frgtanswer;
        this.password = password;

        this.creditsTaking = creditsTaking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFrgtquestion() {
        return frgtquestion;
    }

    public void setFrgtquestion(String frgtquestion) {
        this.frgtquestion = frgtquestion;
    }

    public String getFrgtanswer() {
        return frgtanswer;
    }

    public void setFrgtanswer(String frgtanswer) {
        this.frgtanswer = frgtanswer;
    }

    public void addCourse(Course course){
        this.crnList.add(course.getCrn());
        this.creditsTaking += course.getCreditValue();
    }

}
