package com.general;

import com.general.interfacedevice.AbstractInterfaceDevice;
import com.general.interfacedevice.Command;
import com.general.interfacedevice.DeviceType;
import com.general.smarthomedevice.AbstractSmartHomeDevice;

import java.util.HashMap;
import java.util.Map;

public class HomeSystem {
    Map<DeviceType, AbstractInterfaceDevice> interfaceDeviceMap;

    public HomeSystem() {
        interfaceDeviceMap = new HashMap<>();
    }

    public void addInterfaceDevice(DeviceType deviceType, AbstractInterfaceDevice device) {
        // Check if no existing device of same type exists . If exists throw error
        interfaceDeviceMap.put(deviceType, device);
    }

    // Since only 1 type of interface device can be present
    public boolean addSmartHomeDevice(AbstractSmartHomeDevice smartHomeDevice, DeviceType deviceType) {
        boolean result = false;
        AbstractInterfaceDevice interfaceDevice = interfaceDeviceMap.get(deviceType);
        if (interfaceDevice == null) {
            System.out.println("no such interface device found");
            return result;
        }

        interfaceDevice.addSmartHomeDevice(smartHomeDevice);
        result = true;
        return result;
    }

    public boolean giveCommand(DeviceType deviceType, Command command, Integer deviceId) {
        boolean result = false;
        AbstractInterfaceDevice interfaceDevice = interfaceDeviceMap.get(deviceType);
        if (interfaceDevice == null) {
            System.out.println("no such interface device found");
            return result;
        }

        interfaceDevice.runCommand(command, deviceId);

        return result;
    }

    public void printUsages() {
        for (AbstractInterfaceDevice interfaceDevice : interfaceDeviceMap.values()) {
            interfaceDevice.printUsages();
        }
    }

    public void showAttachedDevices() {
        for (DeviceType deviceType : interfaceDeviceMap.keySet()) {
            System.out.println("Devices attached to: " + deviceType);
            interfaceDeviceMap.get(deviceType).printAttachedDevices();
        }
    }
}
