package com.general.smarthomedevice;

import java.util.List;

public class Light implements SmartHomeDeviceImpl {
    private Integer brightnessLevel = 1;
    private Integer id;

    public Light(Integer id) {
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
        // check if brightness is being set in the correct range of 1 - 10
        System.out.println("Successfully set the brightness to: " + level);
        return false;
    }
}
