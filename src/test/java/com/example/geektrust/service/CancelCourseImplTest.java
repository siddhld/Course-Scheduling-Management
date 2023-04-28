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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancelCourseImplTest {

    Command com1;
    Command com2;
    Command com3;
    CommandExecutor execute1;
    CommandExecutor execute2;
    CommandExecutor execute3;

    private TreeMap<String , Course> courses;
    private Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException, CourseFullException {
        System.setOut(new PrintStream(byteStream));
        com1 = CommandService.getObject().getCommandUsingString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        com2 = CommandService.getObject().getCommandUsingString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        com3 = CommandService.getObject().getCommandUsingString("CANCEL REG-COURSE-ANDY-JAVA");
        execute1 = CommandExecutionFactory.getCommandExecutor(com1);
        execute2 = CommandExecutionFactory.getCommandExecutor(com2);
        execute3 = CommandExecutionFactory.getCommandExecutor(com3);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        execute1.executeCommand(courses , registrationIdCourseMap , com1);
        execute2.executeCommand(courses,registrationIdCourseMap , com2);

    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(()-> execute3.executeCommand(courses, registrationIdCourseMap, com3));
    }

    @Test
    public void testIsCourseAllot() {
        String regId = com3.getCommandParams().get(0);
        registrationIdCourseMap.get(regId).setAllotted(true);
        assertDoesNotThrow(()-> execute3.executeCommand(courses , registrationIdCourseMap , com3));
    }

    @Test
    public void testIsValidRegistration() {
        com3.getCommandParams().set(0, "xyz");
        assertDoesNotThrow(()-> execute3.executeCommand(courses , registrationIdCourseMap , com3));
    }

}
