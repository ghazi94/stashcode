package com.general.smarthomedevice;


public class Light implements SmartHomeDeviceImpl {
    private Integer brightnessLevel = 1;
    private Integer id;
    private boolean isOn = false;

    public Light(Integer id) {
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
        // check if brightness is being set in the correct range of 1 - 10
        System.out.println("Successfully set the brightness to: " + level);
        return false;
    }
}
