package com.general.interfacedevice;

import com.general.smarthomedevice.SmartHomeDeviceImpl;

import java.util.List;

public class Alexa implements InterfaceDeviceImpl {
    @Override
    public void setDeviceType(DeviceType deviceType) {

    }

    @Override
    public DeviceType getDeviceType() {
        return null;
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
