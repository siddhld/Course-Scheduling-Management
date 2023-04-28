package com.example.geektrust;

import com.sidd.coursescheduling.CourseSchedulingApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(byteStream));
    }
    @Test
    public void testMain() throws FileNotFoundException {
        CourseSchedulingApp.main(new String[]{
            "sample_input\\input2.txt"
        });
        assertTrue(!byteStream.toString().trim().isEmpty());
    }

    @Test
    public void testFileNotFoundException() throws IOException {
        try{
            CourseSchedulingApp.main(new String[]{});
        }catch (FileNotFoundException e){
            assertNotNull(e.getMessage());
        }
    }

}
