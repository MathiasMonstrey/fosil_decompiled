package com.fossil;

import com.fasterxml.jackson.databind.JavaType;

public class amu {
    protected Class<?> _class;
    protected int _hashCode;
    protected JavaType _type;
    protected boolean aUR;

    public amu(Class<?> cls, boolean z) {
        this._class = cls;
        this._type = null;
        this.aUR = z;
        this._hashCode = z ? m3728G(cls) : m3727F(cls);
    }

    public amu(JavaType javaType, boolean z) {
        this._type = javaType;
        this._class = null;
        this.aUR = z;
        this._hashCode = z ? m3730t(javaType) : m3729s(javaType);
    }

    public static final int m3727F(Class<?> cls) {
        return cls.getName().hashCode();
    }

    public static final int m3728G(Class<?> cls) {
        return cls.getName().hashCode() + 1;
    }

    public static final int m3729s(JavaType javaType) {
        return javaType.hashCode() - 1;
    }

    public static final int m3730t(JavaType javaType) {
        return javaType.hashCode() - 2;
    }

    public boolean HA() {
        return this.aUR;
    }

    public Class<?> getRawType() {
        return this._class;
    }

    public JavaType getType() {
        return this._type;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public final String toString() {
        if (this._class != null) {
            return "{class: " + this._class.getName() + ", typed? " + this.aUR + "}";
        }
        return "{type: " + this._type + ", typed? " + this.aUR + "}";
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        amu com_fossil_amu = (amu) obj;
        if (com_fossil_amu.aUR != this.aUR) {
            return false;
        }
        if (this._class == null) {
            return this._type.equals(com_fossil_amu._type);
        }
        if (com_fossil_amu._class != this._class) {
            z = false;
        }
        return z;
    }
}
