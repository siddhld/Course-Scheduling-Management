package com.sidd.coursescheduling.factory;

import com.sidd.coursescheduling.constant.CommandOperator;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.service.CommandExecutor;
import com.sidd.coursescheduling.service.ServiceImpl.AllotCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.AddCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.RegisterCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.CancelCourseImpl;

public class CommandExecutionFactory {
    public static CommandExecutor getCommandExecutor(Command command) {
        CommandOperator commandOperator = command.getCommandOperator();
        switch (commandOperator) {
            case CANCEL:
                return new CancelCourseImpl();
            case ADD_COURSE_OFFERING:
                return new AddCourseImpl();
            case REGISTER:
                return new RegisterCourseImpl();
            case ALLOT:
                return new AllotCourseImpl();
            default: return null;
        }
    }
}
