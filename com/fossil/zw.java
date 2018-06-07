package com.fossil;

import java.io.File;

public class zw<A, T, Z, R> implements aab<A, T, Z, R>, Cloneable {
    private un<File, Z> aBW;
    private uo<Z> aBY;
    private uk<T> aBZ;
    private zd<Z, R> aBq;
    private final aab<A, T, Z, R> aFU;
    private un<T, Z> aFt;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return ws();
    }

    public zw(aab<A, T, Z, R> com_fossil_aab_A__T__Z__R) {
        this.aFU = com_fossil_aab_A__T__Z__R;
    }

    public wp<A, T> wq() {
        return this.aFU.wq();
    }

    public void m14178d(un<T, Z> unVar) {
        this.aFt = unVar;
    }

    public void m14177d(uk<T> ukVar) {
        this.aBZ = ukVar;
    }

    public un<File, Z> vF() {
        if (this.aBW != null) {
            return this.aBW;
        }
        return this.aFU.vF();
    }

    public un<T, Z> vG() {
        if (this.aFt != null) {
            return this.aFt;
        }
        return this.aFU.vG();
    }

    public uk<T> vH() {
        if (this.aBZ != null) {
            return this.aBZ;
        }
        return this.aFU.vH();
    }

    public uo<Z> vI() {
        if (this.aBY != null) {
            return this.aBY;
        }
        return this.aFU.vI();
    }

    public zd<Z, R> wr() {
        if (this.aBq != null) {
            return this.aBq;
        }
        return this.aFU.wr();
    }

    public zw<A, T, Z, R> ws() {
        try {
            return (zw) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
