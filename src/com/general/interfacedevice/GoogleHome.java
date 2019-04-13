package com.general.interfacedevice;

public class GoogleHome extends AbstractInterfaceDevice {

    public GoogleHome(String activationCommand) {
        super(activationCommand);
        setDeviceType(DeviceType.GOOGLE_HOME);
    }
}
