package com.portfolio.platform.enums;

public enum Integration {
    Jawbone("jawbone"),
    UnderArmour("underarmour"),
    HealthKit("healthkit"),
    GoogleFit("googlefit");
    
    private String name;

    private Integration(String str) {
        this.name = str;
    }

    public static Integration fromName(String str) {
        for (Integration integration : values()) {
            if (integration.getName().equalsIgnoreCase(str)) {
                return integration;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
