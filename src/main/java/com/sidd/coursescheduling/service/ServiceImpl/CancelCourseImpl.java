package com.sidd.coursescheduling.service.ServiceImpl;

import java.util.Map;
import java.util.TreeMap;

import com.sidd.coursescheduling.constant.Constants;
import com.sidd.coursescheduling.entities.Command;
import com.sidd.coursescheduling.entities.Course;
import com.sidd.coursescheduling.service.CancelCourseService;
import com.sidd.coursescheduling.service.CommandExecutor;

public class CancelCourseImpl implements CommandExecutor, CancelCourseService {
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> regIdCourseMap, Command command) {
        String regId = command.getCommandParams().get(0);
        if (isValidRegistrationID(regId, regIdCourseMap)) {
            if (isCourseAllotted(regId, regIdCourseMap)) {
                System.out.println(regId + " " + Constants.CANCEL_REJECTED);
            } else {
                removeRegisteredEmployee(regId, regIdCourseMap);
                System.out.println(regId + " " + Constants.CANCEL_ACCEPTED);
            }
        } else {
            System.out.println(regId + " " + Constants.CANCEL_REJECTED);
        }
    }

    public boolean isValidRegistrationID(String regId, Map<String, Course> regIdCourseMap) {
        if(regIdCourseMap.get(regId) != null) return true;
        return false;
    }

    public boolean isCourseAllotted(String regId, Map<String, Course> regIdCourseMap) {
        return regIdCourseMap.get(regId).isAllotted();
    }

    public void removeRegisteredEmployee(String regId, Map<String, Course> regIdCourseMap) {
        Course course = regIdCourseMap.get(regId);
        course.getRegisteredEmployees().remove(regId);
        regIdCourseMap.remove(regId);
    }

}
