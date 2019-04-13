package com.general.interfacedevice;

public class Command {
    public CommandType commandType;
    public Integer level;
    public Command(CommandType commandType) {
        // only allow switch on / switch off
        // throw error ... use the other constructor for SET_LEVEL
    }

    public Command(CommandType commandType, Integer level) {


    }
}
