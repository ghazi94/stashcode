package com.general.smarthomedevice;


public class Light extends AbstractSmartHomeDevice {
    private Integer brightnessLevel = 1;

    public Light(Integer id) {
        super(id);
    }

    @Override
    public boolean setVariableValue(Integer level) {
        boolean result = false;
        // check if brightness is being set in the correct range of 1 - 10
        if (level > 0 && level < 11) {
            this.brightnessLevel = level;
            System.out.println("Successfully set the brightness to: " + level);
            result = true;
        } else {
            System.out.println("Invalid fan speed provided");
        }
        return result;
    }

    @Override
    public String toString() {
        return "Light{" +
                "brightnessLevel=" + brightnessLevel +
                ", state=" + this.isOn +
                '}';
    }
}
