package com.fossil;

public abstract class akg extends ajv {
    protected final ajt _idResolver;
    protected final agv _property;

    protected akg(ajt com_fossil_ajt, agv com_fossil_agv) {
        this._idResolver = com_fossil_ajt;
        this._property = com_fossil_agv;
    }

    public String getPropertyName() {
        return null;
    }

    protected String bA(Object obj) {
        String bA = this._idResolver.bA(obj);
        if (bA == null) {
            bB(obj);
        }
        return bA;
    }

    protected String m3577a(Object obj, Class<?> cls) {
        String a = this._idResolver.mo1045a(obj, (Class) cls);
        if (a == null) {
            bB(obj);
        }
        return a;
    }

    protected void bB(Object obj) {
    }
}
