package com.general.interfacedevice;

import com.general.smarthomedevice.SmartHomeDeviceImpl;

import java.util.List;

public class Alexa implements InterfaceDeviceImpl {
    private List<SmartHomeDeviceImpl> attachedDevices;
    private String activationCommand;
    private DeviceType deviceType;

    public Alexa(String activationCommand) {
        this.activationCommand = activationCommand;
        deviceType = DeviceType.ALEXA;
    }

    @Override
    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    @Override
    public void setActivationCommand(String activationCommand) {

    }

    @Override
    public String getActivationCommand() {
        return null;
    }

    @Override
    public void addSmartHomeDevice(SmartHomeDeviceImpl smartHomeDevice) {

    }

    @Override
    public List<SmartHomeDeviceImpl> getSmartHomeDevices() {
        return null;
    }
}
