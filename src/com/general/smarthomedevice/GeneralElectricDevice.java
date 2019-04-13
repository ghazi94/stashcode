package com.general.smarthomedevice;

public class GeneralElectricDevice implements SmartHomeDeviceImpl {
    private Integer id;
    private boolean isOn = false;

    public GeneralElectricDevice(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getDeviceId() {
        return this.id;
    }

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
