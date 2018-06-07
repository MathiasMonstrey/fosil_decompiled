package com.fossil;

import com.fasterxml.jackson.core.JsonEncoding;

public class afo {
    protected final Object _sourceRef;
    protected char[] aMe = null;
    protected JsonEncoding aNg;
    protected final boolean aNh;
    protected final agm aNi;
    protected byte[] aNj = null;
    protected byte[] aNk = null;
    protected byte[] aNl = null;
    protected char[] aNm = null;
    protected char[] aNn = null;

    public afo(agm com_fossil_agm, Object obj, boolean z) {
        this.aNi = com_fossil_agm;
        this._sourceRef = obj;
        this.aNh = z;
    }

    public void m3148a(JsonEncoding jsonEncoding) {
        this.aNg = jsonEncoding;
    }

    public Object Bx() {
        return this._sourceRef;
    }

    public JsonEncoding By() {
        return this.aNg;
    }

    public boolean Bz() {
        return this.aNh;
    }

    public agr BA() {
        return new agr(this.aNi);
    }

    public byte[] BB() {
        br(this.aNj);
        byte[] gA = this.aNi.gA(0);
        this.aNj = gA;
        return gA;
    }

    public byte[] BC() {
        br(this.aNk);
        byte[] gA = this.aNi.gA(1);
        this.aNk = gA;
        return gA;
    }

    public byte[] BD() {
        br(this.aNl);
        byte[] gA = this.aNi.gA(3);
        this.aNl = gA;
        return gA;
    }

    public char[] BE() {
        br(this.aNm);
        char[] gB = this.aNi.gB(0);
        this.aNm = gB;
        return gB;
    }

    public char[] fy(int i) {
        br(this.aNm);
        char[] bG = this.aNi.bG(0, i);
        this.aNm = bG;
        return bG;
    }

    public char[] BF() {
        br(this.aNn);
        char[] gB = this.aNi.gB(1);
        this.aNn = gB;
        return gB;
    }

    public char[] fz(int i) {
        br(this.aMe);
        char[] bG = this.aNi.bG(3, i);
        this.aMe = bG;
        return bG;
    }

    public void m3145S(byte[] bArr) {
        if (bArr != null) {
            m3152c(bArr, this.aNj);
            this.aNj = null;
            this.aNi.m3317b(0, bArr);
        }
    }

    public void m3146T(byte[] bArr) {
        if (bArr != null) {
            m3152c(bArr, this.aNk);
            this.aNk = null;
            this.aNi.m3317b(1, bArr);
        }
    }

    public void m3147U(byte[] bArr) {
        if (bArr != null) {
            m3152c(bArr, this.aNl);
            this.aNl = null;
            this.aNi.m3317b(3, bArr);
        }
    }

    public void m3149a(char[] cArr) {
        if (cArr != null) {
            m3150a(cArr, this.aNm);
            this.aNm = null;
            this.aNi.m3318c(0, cArr);
        }
    }

    public void m3151b(char[] cArr) {
        if (cArr != null) {
            m3150a(cArr, this.aNn);
            this.aNn = null;
            this.aNi.m3318c(1, cArr);
        }
    }

    public void m3153c(char[] cArr) {
        if (cArr != null) {
            m3150a(cArr, this.aMe);
            this.aMe = null;
            this.aNi.m3318c(3, cArr);
        }
    }

    protected final void br(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    protected final void m3152c(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length <= bArr2.length) {
            throw BG();
        }
    }

    protected final void m3150a(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length <= cArr2.length) {
            throw BG();
        }
    }

    private IllegalArgumentException BG() {
        return new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
}
