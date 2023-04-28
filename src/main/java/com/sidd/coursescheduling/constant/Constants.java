package com.sidd.coursescheduling.constant;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
    public static final String ACCEPTED = "ACCEPTED";

    public static final String REJECTED = "REJECTED";
    public static final String CANCEL_ACCEPTED = "CANCEL_ACCEPTED";
    public static final String CANCEL_REJECTED = "CANCEL_REJECTED";
    public static final String allotCourse = "ALLOT-COURSE";
    public static final String addCourse = "ADD-COURSE-OFFERING";

    public static String getValue(String data) {
        String status = "";
        switch (data) {
            case allotCourse:
            status = "ALLOT_COURSE";
            break;
            
            case addCourse:
                status = "ADD_COURSE_OFFERING";
                break;
            
            default:
                status = data;
                break;
        }
        return status;
    }
}
