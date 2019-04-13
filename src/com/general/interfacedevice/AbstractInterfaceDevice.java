package com.general.interfacedevice;

import com.general.smarthomedevice.SmartHomeDeviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractInterfaceDevice {
    private List<SmartHomeDeviceImpl> attachedDevices = new ArrayList<>();
    private Map<Integer, List<Timing>> startEndTimes = new HashMap<>();

    private String activationCommand;
    private DeviceType deviceType;

    public AbstractInterfaceDevice(String activationCommand) {
        this.activationCommand = activationCommand;
    }

    protected void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    public void setActivationCommand(String activationCommand) {
        this.activationCommand = activationCommand;
    }

    public String getActivationCommand() {
        return this.activationCommand;
    }

    public void addSmartHomeDevice(SmartHomeDeviceImpl smartHomeDevice) {
        attachedDevices.add(smartHomeDevice);
    }

    public List<SmartHomeDeviceImpl> getSmartHomeDevices() {
        // make new and set to avoid modification
        return this.attachedDevices;
    }

    public boolean runCommand(Command command, Integer deviceId) {
        if (!command.activationCommand.equalsIgnoreCase(this.activationCommand)) {
            System.out.println("Invalid activation command");
            return false;
        }

        // Check if the device with id is present or not
        SmartHomeDeviceImpl smartHomeDevice = null;
        for (SmartHomeDeviceImpl smartHomeDeviceX : this.attachedDevices) {
            if (smartHomeDeviceX.getDeviceId() == deviceId) {
                smartHomeDevice = smartHomeDeviceX;
                break;
            }
        }
        if (smartHomeDevice == null) {
            System.out.println("No device found");
            return false;
        }

        if (command.commandType == CommandType.SWITCH_ON) {
            boolean result = smartHomeDevice.turnOn();
            if (result) {
                safePut(deviceId, new Timing("ON"));
            }
        } else if (command.commandType == CommandType.SWITCH_OFF) {
            boolean result = smartHomeDevice.turnOff();
            safePut(deviceId, new Timing("OFF"));
        } else if (command.commandType == CommandType.SET_LEVEL) {
            smartHomeDevice.setVariableValue(command.level);
        }

        return false;
    }

    public void printUsages() {
        for (Map.Entry<Integer, List<Timing>> entry : startEndTimes.entrySet()) {
            Integer deviceId = entry.getKey();
            List<Timing> timings = entry.getValue();
            Long cumulativeTime = 0l;
            boolean currentlyOn = false;

            for (int i = 0; i < timings.size() - 1; i++) {
                if (timings.get(i).state.equalsIgnoreCase("ON") &&
                        timings.get(i + 1).state.equalsIgnoreCase("OFF")) {
                    cumulativeTime = cumulativeTime + timings.get(i + 1).time - timings.get(i).time;
                }
            }

            if (timings.get(timings.size() - 1).state.equalsIgnoreCase("ON")) {
                currentlyOn = true;
                cumulativeTime = cumulativeTime + System.currentTimeMillis() - timings.get(timings.size() - 1).time;
            }

            System.out.println("Device id: " + deviceId + " has been on for: " + cumulativeTime + " ms" );
            if (currentlyOn) {
                System.out.println("Device id: " + deviceId + " is also currently on");
            }
        }
    }

    private void safePut(Integer id, Timing timing) {
        if (!startEndTimes.containsKey(id)) {
            startEndTimes.put(id, new ArrayList<>());
        }
        startEndTimes.get(id).add(timing);
    }
}
