package com.general.interfacedevice;

import com.general.smarthomedevice.SmartHomeDeviceImpl;

import java.util.ArrayList;
import java.util.List;

public class AbstractInterfaceDevice {
    private List<SmartHomeDeviceImpl> attachedDevices = new ArrayList<>();
    private String activationCommand;
    private DeviceType deviceType;

    public AbstractInterfaceDevice(String activationCommand) {
        this.activationCommand = activationCommand;
    }

    protected void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    public void setActivationCommand(String activationCommand) {
        this.activationCommand = activationCommand;
    }

    public String getActivationCommand() {
        return this.activationCommand;
    }

    public void addSmartHomeDevice(SmartHomeDeviceImpl smartHomeDevice) {
        attachedDevices.add(smartHomeDevice);
    }

    public List<SmartHomeDeviceImpl> getSmartHomeDevices() {
        // make new and set to avoid modification
        return this.attachedDevices;
    }

    public boolean runCommand(Command command, Integer deviceId) {
        if (!command.activationCommand.equalsIgnoreCase(this.activationCommand)) {
            System.out.println("Invalid activation command");
            return false;
        }

        // Check if the device with id is present or not
        SmartHomeDeviceImpl smartHomeDevice = null;
        for (SmartHomeDeviceImpl smartHomeDeviceX : this.attachedDevices) {
            if (smartHomeDeviceX.getDeviceId() == deviceId) {
                smartHomeDevice = smartHomeDeviceX;
                break;
            }
        }
        if (smartHomeDevice == null) {
            System.out.println("No device found");
            return false;
        }

        if (command.commandType == CommandType.SWITCH_ON) {
            smartHomeDevice.turnOn();
        } else if (command.commandType == CommandType.SWITCH_OFF) {
            smartHomeDevice.turnOff();
        } else if (command.commandType == CommandType.SET_LEVEL) {
            smartHomeDevice.setVariableValue(command.level);
        }

        return false;
    }
}
