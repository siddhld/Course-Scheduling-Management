package com.sidd.coursescheduling.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sidd.coursescheduling.constant.Constants;
import com.sidd.coursescheduling.constant.CommandOperator;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;

public class CommandService {
    static CommandService commandService = null;

    // Creating a Singleton Object
    public static CommandService getCommandService() {
        if (commandService == null) {
            commandService = new CommandService();
        }
        return commandService;
    }

    private void checkCommand(CommandOperator commandOperator, Command command) throws InvalidInputException {
        int expectedArgs = commandOperator.getNumArgs();
        int actualArgs = command.getCommandParams().size();
        if (expectedArgs != actualArgs) {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }


    public Command getCommandUsingString(String line) throws InvalidInputException {
        try {
            String[] commands = line.split(" ");
            CommandOperator commandOperator = CommandOperator.valueOf(Constants.getValue(commands[0]));
            List<String> commandParams = Arrays.stream(commands).skip(1).collect(Collectors.toList());
            Command command = new Command(commandOperator, commandParams);
            this.checkCommand(commandOperator, command);
            return command;
        } catch (Exception ex) {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

}
