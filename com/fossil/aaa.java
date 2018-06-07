package com.fossil;

import java.io.File;

public class aaa<A, T, Z, R> implements aab<A, T, Z, R> {
    private final zd<Z, R> aBq;
    private final zx<T, Z> aFX;
    private final wp<A, T> ayD;

    public aaa(wp<A, T> wpVar, zd<Z, R> zdVar, zx<T, Z> zxVar) {
        if (wpVar == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.ayD = wpVar;
        if (zdVar == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.aBq = zdVar;
        if (zxVar == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.aFX = zxVar;
    }

    public wp<A, T> wq() {
        return this.ayD;
    }

    public zd<Z, R> wr() {
        return this.aBq;
    }

    public un<File, Z> vF() {
        return this.aFX.vF();
    }

    public un<T, Z> vG() {
        return this.aFX.vG();
    }

    public uk<T> vH() {
        return this.aFX.vH();
    }

    public uo<Z> vI() {
        return this.aFX.vI();
    }
}
