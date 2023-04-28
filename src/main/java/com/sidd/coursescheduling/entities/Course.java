package com.sidd.coursescheduling.entities;

import java.util.*;
import lombok.Data;


@Data
public class Course {
    private final String courseID;
    private final String courseName;
    private final String instructor;
    private final Date date;
    private final int minLimit;
    private final int maxLimit;
    private boolean isAllotted;
    private boolean isCancelled;

    private final Map<String , Employee> registeredEmployees;


    public Course(String courseID, String courseName, String instructor, Date date, int minLimit, int maxLimit, boolean isAllotted, boolean isCancelled) {
        registeredEmployees = new TreeMap<>();
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.date = date;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.isAllotted = isAllotted;
        this.isCancelled = isCancelled;
    }


    public String addEmployee(Employee e){
        String registrationID = "REG-COURSE-"+e.getName()+"-"+this.courseName;
        this.registeredEmployees.put(registrationID , e);
        return registrationID;
    }

}
