package com.example.geektrust.service;

import com.sidd.coursescheduling.exceptionHandle.CourseFullException;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.factory.CommandExecutionFactory;
import com.sidd.coursescheduling.service.CommandExecutor;
import com.sidd.coursescheduling.service.CommandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class AddCourseImplTest {

    Command com1;
    CommandExecutor execute;
    private TreeMap<String, Course> courses;
    private Map<String, Course> registrationIdCourseMap;
    private final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(byteStream));
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        com1 = CommandService.getCommandService().getCommandUsingString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        execute = CommandExecutionFactory.getCommandExecutor(com1);
    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(() -> execute.executeCommand(courses, registrationIdCourseMap, com1));
    }

    @Test
    public void testConstructCourse() {
        com1.getCommandParams().set(3, null);
        assertThrows(InvalidInputException.class, () -> execute.executeCommand(courses, registrationIdCourseMap, com1));
    }

    @Test
    public void testSuccessMessage() throws InvalidInputException, CourseFullException {
        execute.executeCommand(courses, registrationIdCourseMap, com1);
        assertEquals("OFFERING-JAVA-JAMES", byteStream.toString().trim());
    }
}
