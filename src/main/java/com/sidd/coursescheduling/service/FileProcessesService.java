package com.sidd.coursescheduling.service;

import java.io.*;

import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import com.sidd.coursescheduling.entities.Command;

public class FileProcessesService {
    private final File file;
    private final BufferedReader bufferReader;

    public FileProcessesService(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        bufferReader = new BufferedReader(new FileReader(file));
    }

    public Command executeLine() throws InvalidInputException, IOException {
        String line = bufferReader.readLine();
        if (line == null) {
            return null;
        }
        try {
            return CommandService.getCommandService().getCommandUsingString(line);
        } catch (InvalidInputException ex) {
            System.out.println(ex.getMessage());
            return executeLine();
        }
    }

}
