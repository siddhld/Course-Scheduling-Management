package com.sidd.coursescheduling;

import com.sidd.coursescheduling.config.Configuration;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;

import java.io.*;

public class CourseSchedulingApp {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            int limit = 1;
            if (args.length != limit) {
                throw new FileNotFoundException("Input file not Found");
            }
            else {
                Configuration.configure(args[0]);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
