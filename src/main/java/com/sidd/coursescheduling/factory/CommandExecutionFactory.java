package com.sidd.coursescheduling.factory;

import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.service.CommandExecutor;
import com.sidd.coursescheduling.service.ServiceImpl.AllotCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.AddCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.RegisterCourseImpl;
import com.sidd.coursescheduling.service.ServiceImpl.CancelCourseImpl;

public class CommandExecutionFactory {
    public static CommandExecutor getCommandExecutor(Command command) {
        CommandExecutor commandExecutor = null;
        if (command != null) {
            switch (command.getCommandOperator()) {
                case CANCEL:
                    commandExecutor = new CancelCourseImpl();
                    break;
                case ADD_COURSE_OFFERING:
                    commandExecutor = new AddCourseImpl();
                    break;
                case REGISTER:
                    commandExecutor = new RegisterCourseImpl();
                    break;
                case ALLOT:
                    commandExecutor = new AllotCourseImpl();
                    break;
                default:
                    break;
            }
        }
        return commandExecutor;
    }
}
