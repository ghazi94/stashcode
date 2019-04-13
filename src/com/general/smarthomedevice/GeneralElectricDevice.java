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
        if (this.isOn) {
            System.out.println("Already on");
            return false;
        }
        this.isOn = true;
        System.out.println("Successfully switched on the fan");
        return true;
    }

    @Override
    public boolean turnOff() {
        if (!this.isOn) {
            System.out.println("Already off");
            return false;
        }
        this.isOn = false;
        System.out.println("Successfully turned off");
        return false;
    }

    @Override
    public boolean setVariableValue(Integer level) {
        // You can throw error here if you want
        System.out.println("General Electric Device does not support any feature with variable value");
        return false;
    }
}
