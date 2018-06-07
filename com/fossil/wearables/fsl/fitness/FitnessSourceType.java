package com.fossil.wearables.fsl.fitness;

import android.text.TextUtils;

public enum FitnessSourceType {
    Device("Device"),
    User("User"),
    Mock("Mock");
    
    private final String name;

    private FitnessSourceType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public static FitnessSourceType find(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].getName().equalsIgnoreCase(str)) {
                    return values()[i];
                }
            }
        }
        return null;
    }
}
