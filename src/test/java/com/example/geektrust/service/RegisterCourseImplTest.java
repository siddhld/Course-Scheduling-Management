package com.example.geektrust.service;

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
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegisterCourseImplTest {
    Command com1;
    Command com2;
    CommandExecutor execute1;
    CommandExecutor execute2;
    private TreeMap<String , Course> courses;
    private Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(byteStream));
        com1 = CommandService.getObject().getCommandUsingString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        com2 = CommandService.getObject().getCommandUsingString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        execute1 = CommandExecutionFactory.getCommandExecutor(com1);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        execute2 = CommandExecutionFactory.getCommandExecutor(com2);
    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(()-> execute2.executeCommand(courses , registrationIdCourseMap , com2));
    }

}
