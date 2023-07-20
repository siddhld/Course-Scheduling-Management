package com.sidd.coursescheduling.config;

import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.factory.LearningManagementSystem;
import com.sidd.coursescheduling.service.FileProcessesService;

import java.io.IOException;

public class Configuration {

    public static void configure(String line) throws IOException, InvalidInputException {
        // Processing the String into file
        FileProcessesService fps = new FileProcessesService(line);
        LearningManagementSystem lms = new LearningManagementSystem("CourseScheduleMaster");
        // Fetching the first line of the file and separating them by the command name and the rest of the Params.
        Command command;
        while ((command = fps.executeLine()) != null) {
            // Constructing an Object by the command name and after that executing it.
            lms.constructAndExecuteCommand(command);
        }
    }

}
