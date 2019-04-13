package com.general.smarthomedevice;

public class GeneralElectricDevice extends AbstractSmartHomeDevice {

    public GeneralElectricDevice(Integer id) {
        super(id);
    }

    @Override
    public boolean setVariableValue(Integer level) {
        // You can throw error here if you want
        System.out.println("General Electric Device does not support any feature with variable value");
        return false;
    }

    @Override
    public String toString() {
        return "GeneralElectricDevice{" +
                "state=" + this.isOn +
                '}';
    }
}
