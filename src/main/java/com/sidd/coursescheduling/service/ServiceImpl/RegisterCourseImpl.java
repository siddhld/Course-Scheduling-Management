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

public class RegisterCourseImpl implements CommandExecutor, RegisterCourseService {

    private static final int EMAIL_INDEX = 0;
    private static final int COURSE_ID_INDEX = 1;

    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> regIdCourseMap, Command command)
            throws InvalidInputException, CourseFullException {
        String courseID = command.getCommandParams().get(1);
        if (!courses.containsKey(courseID)) throw new InvalidInputException("INPUT_DATA_ERROR");

        Course course = courses.get(courseID);
        if (!course.isAllotted() && !course.isCancelled()) {
            Employee employee = CreateEmployeeObject(command);
            register(course, employee, regIdCourseMap);
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
        String email = command.getCommandParams().get(EMAIL_INDEX);
        //                  Passing Email in Employee Constructor
        return new Employee(email);
    }
}
