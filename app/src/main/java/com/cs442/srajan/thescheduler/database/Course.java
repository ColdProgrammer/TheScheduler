package com.cs442.srajan.thescheduler.database;

/**
 * Created by p0rt on 11/26/17.
 *
 *
 */

public class Course {

    private int crn;
    private String creditValue;//credit
    private String courseNumber;//class_id
    private String courseName;//class_name
    private String springClass;//offe_spring2018
    private String courseDescription;//class_info
    private String courseProfessor;
    private String prereq;//prereq
    private String courseDepartment;
    private String courseLocation;

    //Default constructor
    public Course(){}
    //Constructor for course item
    public Course(int crn, String creditValue, String courseNumber, String courseName, String courseDescription, String courseProfessor, String courseDepartment, String courseLocation) {
        this.crn = crn;
        this.creditValue = creditValue;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseProfessor = courseProfessor;
        this.courseDepartment = courseDepartment;
        this.courseLocation = courseLocation;
    }

    public String getSpringClass() {
        return springClass;
    }

    public void setSpringClass(String springClass) {
        this.springClass = springClass;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public String getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(String creditValue) {
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
