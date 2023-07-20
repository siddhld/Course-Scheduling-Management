package com.sidd.coursescheduling.service.ServiceImpl;

import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.service.AddCourseService;
import com.sidd.coursescheduling.service.CommandExecutor;

import java.text.SimpleDateFormat;
import java.util.*;

public class AddCourseImpl implements CommandExecutor, AddCourseService {
    private static final int COURSE_NAME_INDEX = 0;
    private static final int COURSE_INSTRUCTOR_INDEX = 1;
    private static final int DATE_INDEX = 2;
    private static final int MIN_COUNT_INDEX = 3;
    private static final int MAX_COUNT_INDEX = 4;

    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> regIdCourseMap, Command command) throws InvalidInputException {
        List<String> list = command.getCommandParams();
        Course course = constructCourseObject(list);
        addCourse(courses, course);
    }

    public Course constructCourseObject(List<String> list) throws InvalidInputException {
        try {
            String courseName = list.get(COURSE_NAME_INDEX);
            String courseInstructor = list.get(COURSE_INSTRUCTOR_INDEX);
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            Date d = dateFormat.parse(list.get(DATE_INDEX));
            int minCount = Integer.parseInt(list.get(MIN_COUNT_INDEX));
            int maxCount = Integer.parseInt(list.get(MAX_COUNT_INDEX));
            return new Course("OFFERING-" + courseName + "-" + courseInstructor, courseName, courseInstructor, d, minCount, maxCount, false, false);
        } catch (Exception ex) {
            throw new InvalidInputException("INPUT_ERROR");
        }
    }

    public void addCourse(TreeMap<String, Course> courses, Course course) {
        courses.put(course.getCourseID(), course);
        System.out.println(course.getCourseID());
    }
}

