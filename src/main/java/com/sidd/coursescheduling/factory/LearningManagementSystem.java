package com.sidd.coursescheduling.factory;

import com.sidd.coursescheduling.exceptionHandle.CourseFullException;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.service.CommandExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LearningManagementSystem {

    private final String appName;
    private final TreeMap<String, Course> courses;
    private final Map<String,Course> registrationIdCourseMap;

    public LearningManagementSystem(String name) {
        this.appName = name;
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void constructAndExecuteCommand(Command command) throws InvalidInputException {
        // On the basis of command's Operator it will create an object and pass the reference.
        CommandExecutor commandExecutor = CommandExecutionFactory.getCommandExecutor(command);
        try{
            // Creating a course object and filling the values on it from command's commandParam.
            commandExecutor.executeCommand(courses, registrationIdCourseMap, command);
        }catch(CourseFullException ex){
            System.out.println(ex.getMessage());
        }
    }
}
