package com.general;

import com.general.interfacedevice.DeviceType;
import com.general.interfacedevice.InterfaceDeviceImpl;

import java.util.Map;

public class HomeSystem {
    Map<DeviceType, InterfaceDeviceImpl> interfaceDeviceMap;

    public void addInterfaceDevice(DeviceType deviceType, InterfaceDeviceImpl device) {
        interfaceDeviceMap.put(deviceType, device);
    }


}
