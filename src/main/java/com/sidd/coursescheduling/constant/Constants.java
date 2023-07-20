package com.sidd.coursescheduling.constant;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final String ACCEPTED = "ACCEPTED";
    public static final String REJECTED = "REJECTED";
    public static final String CANCEL_ACCEPTED = "CANCEL_ACCEPTED";
    public static final String CANCEL_REJECTED = "CANCEL_REJECTED";
    public static final String ALLOT_COURSE = "ALLOT_COURSE";
    public static final String ADD_COURSE_OFFERING = "ADD_COURSE_OFFERING";

    // Here Additional named constants added for command arguments
    public static final int NUM_ARGS_ADD_COURSE_OFFERING = 5;
    public static final int NUM_ARGS_REGISTER = 2;
    public static final int NUM_ARGS_CANCEL = 1;
    public static final int NUM_ARGS_ALLOT = 1;

    public static String getValue(String data) {
        String status;
        switch (data) {
            case "ALLOT-COURSE":
                status = ALLOT_COURSE;
                break;
            case "ADD-COURSE-OFFERING":
                status = ADD_COURSE_OFFERING;
                break;
            default:
                status = data;
                break;
        }
        return status;
    }
}
