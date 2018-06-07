package com.fossil;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;

public class aip extends aie {
    public String getValueTypeDesc() {
        return JsonLocation.class.getName();
    }

    public boolean canCreateFromObjectWith() {
        return true;
    }

    public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig deserializationConfig) {
        JavaType constructType = deserializationConfig.constructType(Integer.TYPE);
        JavaType constructType2 = deserializationConfig.constructType(Long.TYPE);
        return new SettableBeanProperty[]{m3413a("sourceRef", deserializationConfig.constructType(Object.class), 0), m3413a("byteOffset", constructType2, 1), m3413a("charOffset", constructType2, 2), m3413a("lineNr", constructType, 3), m3413a("columnNr", constructType, 4)};
    }

    private static CreatorProperty m3413a(String str, JavaType javaType, int i) {
        return new CreatorProperty(PropertyName.construct(str), javaType, null, null, null, null, i, null, PropertyMetadata.STD_REQUIRED);
    }

    public Object createFromObjectWith(DeserializationContext deserializationContext, Object[] objArr) {
        return new JsonLocation(objArr[0], bw(objArr[1]), bw(objArr[2]), bx(objArr[3]), bx(objArr[4]));
    }

    private static final long bw(Object obj) {
        return obj == null ? 0 : ((Number) obj).longValue();
    }

    private static final int bx(Object obj) {
        return obj == null ? 0 : ((Number) obj).intValue();
    }
}
