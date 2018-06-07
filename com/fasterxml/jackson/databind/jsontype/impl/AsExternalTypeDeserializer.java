package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.JavaType;
import com.fossil.agv;
import com.fossil.ajs;
import com.fossil.ajt;

public class AsExternalTypeDeserializer extends AsArrayTypeDeserializer {
    private static final long serialVersionUID = 1;

    public AsExternalTypeDeserializer(JavaType javaType, ajt com_fossil_ajt, String str, boolean z, Class<?> cls) {
        super(javaType, com_fossil_ajt, str, z, cls);
    }

    public AsExternalTypeDeserializer(AsExternalTypeDeserializer asExternalTypeDeserializer, agv com_fossil_agv) {
        super(asExternalTypeDeserializer, com_fossil_agv);
    }

    public ajs forProperty(agv com_fossil_agv) {
        return com_fossil_agv == this._property ? this : new AsExternalTypeDeserializer(this, com_fossil_agv);
    }

    public As getTypeInclusion() {
        return As.EXTERNAL_PROPERTY;
    }

    protected boolean _usesExternalId() {
        return true;
    }
}
