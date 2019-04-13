package com.general.smarthomedevice;

public abstract class AbstractSmartHomeDevice {
    private Integer id;
    protected boolean isOn = false;

    public AbstractSmartHomeDevice(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return this.id;
    }

    public boolean turnOn() {
        if (this.isOn) {
            System.out.println("Already on");
            return false;
        }
        this.isOn = true;
        System.out.println("Successfully switched on the fan");
        return true;
    }

    public boolean turnOff() {
        if (!this.isOn) {
            System.out.println("Already off");
            return false;
        }
        this.isOn = false;
        System.out.println("Successfully turned off");
        return false;
    }

    public abstract boolean setVariableValue(Integer level);
}
