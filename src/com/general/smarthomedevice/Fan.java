package com.general.smarthomedevice;

public class Fan implements SmartHomeDeviceImpl {
    private Integer id;
    private Integer fanSpeed = 1;

    public Fan(Integer id) {
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
        // check if fan speed is being set in the correct range of 1 - 5
        System.out.println("Successfully set the fan speed to: " + level);
        return false;
    }
}
