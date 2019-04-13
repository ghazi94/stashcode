package com.general.interfacedevice;

import com.general.smarthomedevice.AbstractSmartHomeDevice;

import java.util.List;

/*
    Unused command for now
 */
public interface InterfaceDeviceImpl {
    DeviceType getDeviceType();

    void setActivationCommand(String activationCommand);
    String getActivationCommand();

    void addSmartHomeDevice(AbstractSmartHomeDevice smartHomeDevice);
    List<AbstractSmartHomeDevice> getSmartHomeDevices();

    boolean runCommand(Command command, Integer deviceId, String activationCommand);
}
