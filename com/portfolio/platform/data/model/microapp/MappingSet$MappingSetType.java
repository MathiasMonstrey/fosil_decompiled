package com.portfolio.platform.data.model.microapp;

public enum MappingSet$MappingSetType {
    FEATURE(0),
    DEFAULT(1),
    USER_SAVED(2),
    USER_NOT_SAVED(3);
    
    private int value;

    private MappingSet$MappingSetType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static MappingSet$MappingSetType fromInt(int i) {
        for (MappingSet$MappingSetType mappingSet$MappingSetType : values()) {
            if (mappingSet$MappingSetType.getValue() == i) {
                return mappingSet$MappingSetType;
            }
        }
        return FEATURE;
    }
}
