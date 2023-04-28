package com.sidd.coursescheduling.service;

import com.sidd.coursescheduling.entities.Course;

public interface AllotCourseService {
    void setCourse(Course course);
    void printCourse(Course course);
}
