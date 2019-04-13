package com.general;

import com.general.interfacedevice.Alexa;
import com.general.interfacedevice.Command;
import com.general.interfacedevice.CommandType;
import com.general.interfacedevice.DeviceType;
import com.general.smarthomedevice.Fan;

public class Main {
    public static void main(String[] args) {
	    // write your code here
        HomeSystem homeSystem = new HomeSystem();

        Alexa alexa = new Alexa("Alexa");
        homeSystem.addInterfaceDevice(DeviceType.ALEXA, alexa);

        Fan livingRoomFan = new Fan(1);
        // Since only 1 type of interface device can be present
        homeSystem.addSmartHomeDevice(livingRoomFan, DeviceType.ALEXA);

        // Should not work due to "Ok Alexa"
        try {
            Command command = new Command(CommandType.SWITCH_ON, "Ok Alexa");
            homeSystem.giveCommand(DeviceType.ALEXA, command, 1);

            command = new Command(CommandType.SWITCH_ON, "Alexa");
            homeSystem.giveCommand(DeviceType.ALEXA, command, 1);

            Thread.sleep(34);
            command = new Command(CommandType.SWITCH_OFF, "Alexa");
            homeSystem.giveCommand(DeviceType.ALEXA, command, 1);

            Thread.sleep(40);
            command = new Command(CommandType.SWITCH_ON, "Alexa");
            homeSystem.giveCommand(DeviceType.ALEXA, command, 1);

        } catch (Exception e) {
            System.out.println(e);
        }

        homeSystem.printUsages();
    }
}
