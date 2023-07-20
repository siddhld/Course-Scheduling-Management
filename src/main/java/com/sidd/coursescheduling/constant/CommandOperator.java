package com.sidd.coursescheduling.constant;

public enum CommandOperator {
    ADD_COURSE_OFFERING(Constants.NUM_ARGS_ADD_COURSE_OFFERING),
    REGISTER(Constants.NUM_ARGS_REGISTER),
    CANCEL(Constants.NUM_ARGS_CANCEL),
    ALLOT(Constants.NUM_ARGS_ALLOT);
    private final int numArgs;

    CommandOperator(int numArgs) {
        this.numArgs = numArgs;
    }

    public int getNumArgs() {
        return numArgs;
    }
}

