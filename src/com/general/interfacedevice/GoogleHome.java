package com.general.interfacedevice;

import com.general.smarthomedevice.SmartHomeDeviceImpl;

import java.util.List;

public class GoogleHome implements InterfaceDeviceImpl {
    private List<SmartHomeDeviceImpl> attachedDevices;
    private String activationCommand;
    private DeviceType deviceType;

    public GoogleHome(String activationCommand) {
        this.activationCommand = activationCommand;
        deviceType = DeviceType.GOOGLE_HOME;
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
