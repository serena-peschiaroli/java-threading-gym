package com.threading.gym;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Gym gym1 = new Gym(5, new HashMap<>(){
            {
                put(MachineType.LEGPRESSMACHINE, 5);
                put(MachineType.BARBELL, 5);
                put(MachineType.SQUATMACHINE, 5);
                put(MachineType.LEGEXTENSIONMACHINE, 5);
                put(MachineType.LEGCURLMACHINE, 5);
                put(MachineType.LATPULLDOWNMACHINE, 5);
                put(MachineType.CABLECROSSOVERMACHINE, 5);
            }
        });

        gym1.openForTheDay();
    }
}
