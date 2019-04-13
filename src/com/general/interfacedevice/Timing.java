package com.general.interfacedevice;

public class Timing {
    public Timing(String state) {
        this.state = state;
        this.time = System.currentTimeMillis();
    }
    public String state;
    public Long time;
}
