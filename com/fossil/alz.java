package com.fossil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class alz {
    protected final Type aVf;
    protected final Class<?> aVg;
    protected final ParameterizedType aVh;
    protected alz aVi;
    protected alz aVj;

    public alz(Type type) {
        this.aVf = type;
        if (type instanceof Class) {
            this.aVg = (Class) type;
            this.aVh = null;
        } else if (type instanceof ParameterizedType) {
            this.aVh = (ParameterizedType) type;
            this.aVg = (Class) this.aVh.getRawType();
        } else {
            throw new IllegalArgumentException("Type " + type.getClass().getName() + " can not be used to construct HierarchicType");
        }
    }

    private alz(Type type, Class<?> cls, ParameterizedType parameterizedType, alz com_fossil_alz, alz com_fossil_alz2) {
        this.aVf = type;
        this.aVg = cls;
        this.aVh = parameterizedType;
        this.aVi = com_fossil_alz;
        this.aVj = com_fossil_alz2;
    }

    public alz GS() {
        alz GS = this.aVi == null ? null : this.aVi.GS();
        alz com_fossil_alz = new alz(this.aVf, this.aVg, this.aVh, GS, null);
        if (GS != null) {
            GS.m3806b(com_fossil_alz);
        }
        return com_fossil_alz;
    }

    public void m3805a(alz com_fossil_alz) {
        this.aVi = com_fossil_alz;
    }

    public final alz GT() {
        return this.aVi;
    }

    public void m3806b(alz com_fossil_alz) {
        this.aVj = com_fossil_alz;
    }

    public final alz GU() {
        return this.aVj;
    }

    public final boolean GV() {
        return this.aVh != null;
    }

    public final ParameterizedType GW() {
        return this.aVh;
    }

    public final Class<?> getRawClass() {
        return this.aVg;
    }

    public String toString() {
        if (this.aVh != null) {
            return this.aVh.toString();
        }
        return this.aVg.getName();
    }
}
