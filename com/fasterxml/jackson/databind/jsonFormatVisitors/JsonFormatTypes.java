package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fossil.aes;
import java.util.HashMap;
import java.util.Map;

public enum JsonFormatTypes {
    STRING,
    NUMBER,
    INTEGER,
    BOOLEAN,
    OBJECT,
    ARRAY,
    NULL,
    ANY;
    
    private static final Map<String, JsonFormatTypes> aTg = null;

    static {
        aTg = new HashMap();
        JsonFormatTypes[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            JsonFormatTypes jsonFormatTypes = values[i];
            aTg.put(jsonFormatTypes.name().toLowerCase(), jsonFormatTypes);
            i++;
        }
    }

    @aes
    public String value() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static JsonFormatTypes forValue(String str) {
        return (JsonFormatTypes) aTg.get(str);
    }
}
