package com.example.SmartIot.constant;

public class AirConditionerConstants {

    public enum Mode {
        COOL,
        HEAT,
        FAN,
        AUTO;

        // public static Mode getEnum(String name){
        //     for(Mode a : Mode.values()) {
        //      if(a.name().equals(name)) {
        //       return a;
        //      }
        //     }
        //     return null;
        //       }
    }

    public enum FanSpeed {
        LOW,
        MEDIUM,
        HIGH,
        AUTO;

        
    }
}
