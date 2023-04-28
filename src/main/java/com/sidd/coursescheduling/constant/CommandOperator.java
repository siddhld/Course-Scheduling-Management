package com.sidd.coursescheduling.constant;

public enum CommandOperator {
    ADD_COURSE_OFFERING(5),
    REGISTER(2),
    CANCEL(1),
    ALLOT(1);
    private final Integer arguments;
    CommandOperator(Integer numArgs){
        this.arguments = numArgs;
    }
    public Integer getArguments() {
        return arguments;
    }
}

