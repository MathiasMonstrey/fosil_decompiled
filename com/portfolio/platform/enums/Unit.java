package com.portfolio.platform.enums;

public enum Unit {
    IMPERIAL("imperial"),
    METRIC("metric");
    
    private String value;

    private Unit(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static Unit fromString(String str) {
        if (str.equalsIgnoreCase("imperial")) {
            return IMPERIAL;
        }
        return METRIC;
    }
}
