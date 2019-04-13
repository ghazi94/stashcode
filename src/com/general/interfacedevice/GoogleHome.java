package com.general.interfacedevice;

import com.general.smarthomedevice.SmartHomeDeviceImpl;

import java.util.ArrayList;
import java.util.List;

public class GoogleHome implements InterfaceDeviceImpl {
    private List<SmartHomeDeviceImpl> attachedDevices = new ArrayList<>();
    private String activationCommand;
    private DeviceType deviceType;

    public GoogleHome(String activationCommand, Integer id) {
        this.activationCommand = activationCommand;
        deviceType = DeviceType.GOOGLE_HOME;
    }

    @Override
    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    @Override
    public void setActivationCommand(String activationCommand) {
        this.activationCommand = activationCommand;
    }

    @Override
    public String getActivationCommand() {
        return this.activationCommand;
    }

    @Override
    public void addSmartHomeDevice(SmartHomeDeviceImpl smartHomeDevice) {
        attachedDevices.add(smartHomeDevice);
    }

    @Override
    public List<SmartHomeDeviceImpl> getSmartHomeDevices() {
        // make new and send - to avoid modification
        return this.attachedDevices;
    }

    @Override
    public boolean runCommand(Command command, Integer deviceId, String activationCommand) {
        if (!activationCommand.equalsIgnoreCase(this.activationCommand)) {
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

        CommandUtility.runCommand(command, smartHomeDevice);

        return false;
    }
}
