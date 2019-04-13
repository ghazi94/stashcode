package com.general.smarthomedevice;

public interface SmartHomeDeviceImpl {
    public Integer getDeviceId();
    boolean turnOn();
    boolean turnOff();
    boolean setVariableValue(Integer level);
}
