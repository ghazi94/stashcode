package com.general.smarthomedevice;


public class Light extends AbstractSmartHomeDevice {
    private Integer brightnessLevel = 1;

    public Light(Integer id) {
        super(id);
    }

    @Override
    public boolean setVariableValue(Integer level) {
        // check if brightness is being set in the correct range of 1 - 10
        System.out.println("Successfully set the brightness to: " + level);
        return false;
    }
}
