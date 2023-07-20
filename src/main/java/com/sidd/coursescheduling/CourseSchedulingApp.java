package com.sidd.coursescheduling;

import com.sidd.coursescheduling.config.Configuration;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;

import java.io.*;

public class CourseSchedulingApp {
    private static final int INPUT_FILE_LIMIT = 1;

    public static void main(String[] args) throws FileNotFoundException{
        try {
            if (args.length != INPUT_FILE_LIMIT) {
                throw new FileNotFoundException("Input file not Found");
            }
            else {
                Configuration.configure(args[0]);
            }
        } catch (IOException | InvalidInputException ex){
            System.out.println(ex.getMessage());
        }
    }
}
