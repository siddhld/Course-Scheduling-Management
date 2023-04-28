package com.sidd.coursescheduling.service;

import java.util.Map;
import java.util.TreeMap;

import com.sidd.coursescheduling.exceptionHandle.CourseFullException;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;


public interface CommandExecutor {
    void executeCommand(TreeMap<String, Course> courses, Map<String, Course> regIdCourseMap, Command command) throws InvalidInputException, CourseFullException;
}
