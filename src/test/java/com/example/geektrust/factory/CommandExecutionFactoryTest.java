package com.example.geektrust.factory;

import com.sidd.coursescheduling.constant.CommandOperator;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.factory.CommandExecutionFactory;
import com.sidd.coursescheduling.service.ServiceImpl.AddCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.AllotCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.CancelCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.RegisterCourseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;

public class CommandExecutionFactoryTest {

    Command com;
    @BeforeEach
    public void setup(){
      com = new Command(CommandOperator.ADD_COURSE_OFFERING,null);
    }

    @Test
    public void testCommandExecutionFactory(){
        assertEquals(CommandExecutionFactory.getCommandExecutor(com).getClass(), new AddCourseImpl().getClass());
        com = new Command(CommandOperator.REGISTER,null);
        assertEquals(CommandExecutionFactory.getCommandExecutor(com).getClass(), new RegisterCourseImpl().getClass());
        com = new Command(CommandOperator.ALLOT,null);
        assertEquals(CommandExecutionFactory.getCommandExecutor(com).getClass(), new AllotCourseImpl().getClass());
        com = new Command(CommandOperator.CANCEL,null);
        assertEquals(CommandExecutionFactory.getCommandExecutor(com).getClass(), new CancelCourseImpl().getClass());
    }

}
