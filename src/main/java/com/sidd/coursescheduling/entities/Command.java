package com.sidd.coursescheduling.entities;

import com.sidd.coursescheduling.constant.CommandOperator;
import java.util.List;
import lombok.Getter;


@Getter
public class Command {
    private final CommandOperator commandOperator;
    private final List<String> commandParams;

    public Command(CommandOperator commandOperator, List<String> commandParams){
        this.commandOperator = commandOperator;
        this.commandParams = commandParams;
    }
}
