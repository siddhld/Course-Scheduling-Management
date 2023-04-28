package com.sidd.coursescheduling.service.ServiceImpl;

import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.service.AddCourseService;
import com.sidd.coursescheduling.service.CommandExecutor;

import java.text.SimpleDateFormat;
import java.util.*;

public class AddCourseImpl implements CommandExecutor, AddCourseService {

    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> regIdCourseMap, Command command) throws InvalidInputException {
        List<String> list = command.getCommandParams();
        Course course = constructCourseObject(list);
        addCourse(courses, course);
    }

    public Course constructCourseObject(List<String> list) throws InvalidInputException {
        Course course = null;
        try{
            String courseName = list.get(0);
            String courseInstructor = list.get(1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            Date d = dateFormat.parse(list.get(2));
            int minCount = Integer.parseInt(list.get(3));
            int maxCount = Integer.parseInt(list.get(4));
            course = new Course("OFFERING-"+courseName+"-"+courseInstructor,courseName , courseInstructor , d ,minCount , maxCount , false, false);
        }catch (Exception ex){
            throw new InvalidInputException("INPUT_ERROR");
        }
        return course;
    }

    public void addCourse(TreeMap<String, Course> courses, Course course){
        courses.put(course.getCourseID(),course);
        System.out.println(course.getCourseID());
    }

}
