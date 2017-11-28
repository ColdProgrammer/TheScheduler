package com.cs442.srajan.thescheduler.database;


/**
 * been sick after fam visited from overseas for the break, sorry about being mia
 * Created by hiraazfar on 11/26/2017.
 */

public class ScheduleAlg {
    //basic algorithm, arbitirary everything, need to // FIXME: 11/26/2017
    //will extend other Databsae Obj (I Think its name is DAO)

    public void CreateSchedule() {

        //need user db with already inputted courses, lets name this db CoursesTaken
        //need courses db with all available courses (same as one in google doc), name it CourseDB
            //this CourseDB has column names class_id	class_name	offr_spring2018?	class_info	prereq	corereq	credit	attributes
        //need requirements db with required courses for major, call it CSReqDB

        //basic alg pseudocode:
        /*
        //making a schedule of 4-6 classes

        first check if any required courses left:

        let Table Z =

        SELECT <class_id, class_name> FROM CoursesTaken CT
        RIGHT JOIN CSReqDB CR
        ON CT.classID = CR.classID
        WHERE CT.classID IS NULL

        if Table Z = Null, then tell user ("No more classes to take")
        if Table Z has <= 6 courses, give user Table Z as schedule

        else{ //now the fun begins
        //Table Z is the courses the USER needs to eventually take
        //need to parse for prereqs

        SELECT <class_id, class_name> FROM Table Z





        }

         */

    }

}
