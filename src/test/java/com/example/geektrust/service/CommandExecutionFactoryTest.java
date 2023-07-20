package com.example.geektrust.service;

import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.factory.CommandExecutionFactory;
import com.sidd.coursescheduling.service.CommandService;
import com.sidd.coursescheduling.service.ServiceImpl.AddCourseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandExecutionFactoryTest {

    Command com1;
    Command com2;

    @BeforeEach
    public void setUp() throws InvalidInputException {
        com1 = CommandService.getCommandService().getCommandUsingString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        com2 = CommandService.getCommandService().getCommandUsingString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
    }

    @Test
    public void getExecutorTest() {
        Assertions.assertTrue(CommandExecutionFactory.getCommandExecutor(com1) instanceof AddCourseImpl);
        Assertions.assertFalse(CommandExecutionFactory.getCommandExecutor(com2) instanceof AddCourseImpl);
    }

}
