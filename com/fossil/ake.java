package com.fossil;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public abstract class ake implements ajt {
    protected final JavaType _baseType;
    protected final TypeFactory _typeFactory;

    protected ake() {
        this(null, null);
    }

    protected ake(JavaType javaType, TypeFactory typeFactory) {
        this._baseType = javaType;
        this._typeFactory = typeFactory;
    }

    public void mo1043m(JavaType javaType) {
    }

    public String Gi() {
        return mo1045a(null, this._baseType.getRawClass());
    }

    @Deprecated
    public JavaType bT(String str) {
        return mo1042a(null, str);
    }

    public JavaType mo1042a(agw com_fossil_agw, String str) {
        return bT(str);
    }

    public String Gj() {
        return null;
    }
}
