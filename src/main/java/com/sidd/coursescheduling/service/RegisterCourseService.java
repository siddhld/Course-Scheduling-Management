package com.sidd.coursescheduling.service;

import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.entities.Employee;
import com.sidd.coursescheduling.exceptionHandle.CourseFullException;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;

import java.util.Map;

public interface RegisterCourseService {
    void register(Course course, Employee employee, Map<String, Course> regIdCourseMap) throws CourseFullException;
    void registerEmployeeToCourse(Employee employee, Course course, Map<String, Course> regIdCourseMap);
    Employee CreateEmployeeObject(Command command) throws InvalidInputException;
}
