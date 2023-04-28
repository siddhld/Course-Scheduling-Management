package com.sidd.coursescheduling.service;

import com.sidd.coursescheduling.entities.Course;

import java.util.Map;

public interface CancelCourseService {
    boolean isValidRegistrationID(String regId, Map<String, Course> regIdCourseMap);
    boolean isCourseAllotted(String regId, Map<String, Course> regIdCourseMap);
    void removeRegisteredEmployee(String regId, Map<String, Course> regIdCourseMap);
}
