package com.fossil.wearables.fsl.fitness;

import java.util.HashMap;
import java.util.Map;

public enum FitnessMovementType {
    WALKING("walking"),
    RUNNING("running"),
    BIKING("biking");
    
    private static final Map<String, FitnessMovementType> map = null;
    private final String name;

    static {
        map = new HashMap();
        FitnessMovementType[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            FitnessMovementType fitnessMovementType = values[i];
            map.put(fitnessMovementType.name, fitnessMovementType);
            i++;
        }
    }

    public static FitnessMovementType valueFor(String str) {
        return (FitnessMovementType) map.get(str);
    }

    private FitnessMovementType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
