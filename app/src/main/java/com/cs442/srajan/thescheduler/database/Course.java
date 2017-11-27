package com.cs442.srajan.thescheduler.database;

/**
 * Created by p0rt on 11/26/17.
 */

public class Course {

    private int crn;
    private int creditValue;

    private String courseNumber;
    private String courseName;
    private String courseDescription;
    private String courseProfessor;
    private String courseDepartment;
    private String courseLocation;

    //Constructor for course item
    public Course(int crn, int creditValue, String courseNumber, String courseName, String courseDescription, String courseProfessor, String courseDepartment, String courseLocation) {
        this.crn = crn;
        this.creditValue = creditValue;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseProfessor = courseProfessor;
        this.courseDepartment = courseDepartment;
        this.courseLocation = courseLocation;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public int getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseProfessor() {
        return courseProfessor;
    }

    public void setCourseProfessor(String courseProfessor) {
        this.courseProfessor = courseProfessor;
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        this.courseDepartment = courseDepartment;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }
}
