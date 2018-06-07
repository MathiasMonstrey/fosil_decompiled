package com.portfolio.platform.data.model.microapp;

public enum SavedPreset$MappingSetType {
    RECOMMENDED("recommended"),
    DEFAULT("default"),
    USER_SAVED("saved"),
    USER_NOT_SAVED("not saved");
    
    private String value;

    private SavedPreset$MappingSetType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static SavedPreset$MappingSetType fromString(String str) {
        for (SavedPreset$MappingSetType savedPreset$MappingSetType : values()) {
            if (savedPreset$MappingSetType.getValue().equals(str)) {
                return savedPreset$MappingSetType;
            }
        }
        return USER_SAVED;
    }
}
