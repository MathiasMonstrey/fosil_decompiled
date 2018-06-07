package com.fossil;

import android.graphics.Rect;
import android.graphics.RectF;

public abstract class cih {
    protected String cdL;
    protected boolean cdM;
    private int cdN;
    private RectF cdO;
    private Rect cdP;
    private boolean cdQ = false;

    protected cih(String str) {
        this.cdL = str;
    }

    public String Yo() {
        return this.cdL;
    }

    public boolean Yp() {
        return this.cdM;
    }

    public void bL(boolean z) {
        this.cdM = z;
    }

    public int Yq() {
        return this.cdN;
    }

    public void jr(int i) {
        this.cdN = i;
    }

    public RectF Yr() {
        return this.cdO;
    }

    public void m6505b(RectF rectF) {
        this.cdO = rectF;
    }

    public void m6506m(Rect rect) {
        this.cdP = rect;
    }

    public boolean Ys() {
        return this.cdQ;
    }
}
