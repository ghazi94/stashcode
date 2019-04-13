package com.general.smarthomedevice;

public class GeneralElectricDevice implements SmartHomeDeviceImpl {


    @Override
    public boolean turnOn() {
        return false;
    }

    @Override
    public boolean turnOff() {
        return false;
    }

    @Override
    public boolean setVariableValue(Integer level) {
        // You can throw error here if you want
        System.out.println("General Electric Device does not support any feature with variable value");
        return false;
    }
}
