package com.sidd.coursescheduling.service.ServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.entities.Employee;
import com.sidd.coursescheduling.service.AllotCourseService;
import com.sidd.coursescheduling.service.CommandExecutor;

public class AllotCourseImpl implements CommandExecutor, AllotCourseService {
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> regIdCourseMap, Command command)
            throws InvalidInputException {
        String courseId = command.getCommandParams().get(0);
        Course course = courses.get(courseId);
        if (course != null) {
            setCourse(course);
        } else {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    public void setCourse(Course course){
        if (course.getRegisteredEmployees().size() > course.getMinLimit()) {
            course.setAllotted(true);
            printCourse(course);
        } else {
            course.setCancelled(true);
            printCourse(course);
        }
    }

    public void printCourse(Course course) {
        String status = course.isCancelled() ? "COURSE_CANCELED" : "CONFIRMED";
        for (Map.Entry<String, Employee> employee : course.getRegisteredEmployees().entrySet()) {
            DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            System.out.println(employee.getKey() + " " + employee.getValue().getEmailAddress() + " "
                    + course.getCourseID() + " " + course.getCourseName() + " " + course.getInstructor() + " "
                    + dateFormat.format(course.getDate()) + " " + status);
        }
    }
}
