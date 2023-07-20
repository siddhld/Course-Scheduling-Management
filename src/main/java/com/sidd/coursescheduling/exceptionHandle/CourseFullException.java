package com.sidd.coursescheduling.exceptionHandle;

public class CourseFullException extends Exception {
    public CourseFullException(String msg) {
        super(msg);
    }
}
