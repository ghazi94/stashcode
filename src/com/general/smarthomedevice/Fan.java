package com.general.smarthomedevice;

public class Fan implements SmartHomeDeviceImpl {
    private Integer id;
    private Integer fanSpeed = 1;
    private boolean isOn = false;

    public Fan(Integer id) {
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
        // check if fan speed is being set in the correct range of 1 - 5
        System.out.println("Successfully set the fan speed to: " + level);
        return false;
    }
}
