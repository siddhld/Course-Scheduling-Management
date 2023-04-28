package com.sidd.coursescheduling.entities;

import com.sidd.coursescheduling.constant.Constants;
import com.sidd.coursescheduling.exceptionHandle.InvalidInputException;
import lombok.Getter;

@Getter
public class Employee {

    private final String name;
    private final String emailAddress;

    public Employee(String emailAddress) throws InvalidInputException {
        if (emailAddress != null && Constants.VALID_EMAIL_REGEX.matcher(emailAddress).matches()) {
            this.emailAddress = emailAddress;
            this.name = this.emailAddress.substring(0, this.emailAddress.indexOf('@'));
        } else {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

}
