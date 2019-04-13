package com.general.smarthomedevice;

public class Fan extends AbstractSmartHomeDevice {
    private Integer id;
    private Integer fanSpeed = 1;
    private boolean isOn = false;

    public Fan(Integer id) {
        super(id);
    }

    @Override
    public boolean setVariableValue(Integer level) {
        // check if fan speed is being set in the correct range of 1 - 5
        System.out.println("Successfully set the fan speed to: " + level);
        return false;
    }
}
