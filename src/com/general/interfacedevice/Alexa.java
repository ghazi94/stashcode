package com.general.interfacedevice;

public class Alexa extends AbstractInterfaceDevice {

    public Alexa(String activationCommand) {
        super(activationCommand);
        setDeviceType(DeviceType.ALEXA);
    }
}
