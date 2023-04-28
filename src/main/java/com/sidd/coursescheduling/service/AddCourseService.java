package com.sidd.coursescheduling.service;

import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;

import java.util.List;
import java.util.TreeMap;

public interface AddCourseService {
    Course constructCourseObject(List<String> list) throws InvalidInputException;
    void addCourse(TreeMap<String, Course> courses, Course course);
}
