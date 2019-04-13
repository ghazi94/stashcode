package com.general.interfacedevice;

import com.general.smarthomedevice.SmartHomeDeviceImpl;

import java.util.List;

public interface InterfaceDeviceImpl {
    DeviceType getDeviceType();

    void setActivationCommand(String activationCommand);
    String getActivationCommand();

    void addSmartHomeDevice(SmartHomeDeviceImpl smartHomeDevice);
    List<SmartHomeDeviceImpl> getSmartHomeDevices();

    boolean runCommand(Command command, Integer deviceId, String activationCommand);
}
