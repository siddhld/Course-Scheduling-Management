package com.sidd.coursescheduling.service.ServiceImpl;

import java.util.Map;
import java.util.TreeMap;

import com.sidd.coursescheduling.constant.Constants;
import com.sidd.coursescheduling.exceptionHandle.CourseFullException;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.entities.Employee;
import com.sidd.coursescheduling.service.CommandExecutor;
import com.sidd.coursescheduling.service.RegisterCourseService;

public class RegisterCourseImpl implements CommandExecutor, RegisterCourseService{

    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> regIdCourseMap, Command command)
            throws InvalidInputException, CourseFullException {
        String courseID = command.getCommandParams().get(1);
        Employee employee = CreateEmployeeObject(command);
        if (courses.containsKey(courseID)) {
            Course course = courses.get(courseID);
            if (!course.isAllotted() || course.isCancelled())
                register(course, employee, regIdCourseMap);
        } else {
            System.out.println("INPUT_DATA_ERROR");
        }

    }

     public void register(Course course, Employee employee, Map<String, Course> regIdCourseMap) throws CourseFullException {
        if (course.getRegisteredEmployees().size() != course.getMaxLimit()) {
            registerEmployeeToCourse(employee, course, regIdCourseMap);
        } else {
            throw new CourseFullException("COURSE_FULL_ERROR");
        }
    }

    public void registerEmployeeToCourse(Employee employee, Course course, Map<String, Course> regIdCourseMap) {
        String regID = course.addEmployee(employee);
        regIdCourseMap.put(regID, course);
        System.out.println(regID + " " + Constants.ACCEPTED);
    }

    public Employee CreateEmployeeObject(Command command) throws InvalidInputException {
        //                  Passing Email in Constructor
        return new Employee(command.getCommandParams().get(0));
    }
}
