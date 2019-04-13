package com.general.interfacedevice;

public class Command {
    public String activationCommand;
    public CommandType commandType;
    public Integer level;
    public Command(CommandType commandType, String activationCommand) throws Exception {
        // only allow switch on / switch off
        // throw error ... use the other constructor for SET_LEVEL
        if (commandType == CommandType.SET_LEVEL) {
            throw new Exception("Please use a different constructor for SET_LEVEL type command");
        }
        this.commandType = commandType;
        this.activationCommand = activationCommand;
    }

    public Command(CommandType commandType, Integer level, String activationCommand) {
        this.commandType = commandType;
        this.level = level;
        this.activationCommand = activationCommand;
    }
}
